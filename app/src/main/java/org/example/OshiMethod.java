package org.example;

import oshi.SystemInfo;
import oshi.hardware.Sensors;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.CentralProcessor.LogicalProcessor;
import oshi.hardware.CentralProcessor.PhysicalProcessor;
import oshi.hardware.CentralProcessor.ProcessorCache;
import oshi.hardware.UsbDevice;
import oshi.util.FormatUtil;
import oshi.hardware.HWDiskStore;

import java.util.List;


class OshiMethod {

    protected SystemInfo systeminfo;
    protected HardwareAbstractionLayer hardware;
    protected CentralProcessor cpu;
    protected GlobalMemory memory;


    public OshiMethod() {
        initSystemInfo();
        initHardware();
        initCentralProcessor();
        initMemory();
        initSensors();
    }
    protected String formatBytes(long bytes) {//This Function was written by chatGPT but is actually extremely useful, so I might keep it
        double value = bytes;
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int i = 0;
        while (value >= 1024 && i < units.length - 1) {
            value /= 1024;
            i++;
        }
        return String.format("%.2f %s", value, units[i]);
    }

    public void initSystemInfo() {
        systeminfo = new SystemInfo();


    }
    public void initHardware() {
        hardware = systeminfo.getHardware();

    }
    public void initCentralProcessor() {
        cpu = hardware.getProcessor();
    }
    public void initMemory() {
        memory = hardware.getMemory();
    }

    public void initSensors() {
        Sensors sensor = hardware.getSensors();
    }

    /*public void printSystemSpecifics() {
        System.out.println("\n=== System Specifications ===");
        System.out.printf("%-25s | %s\n ", "Name", cpu.getProcessorIdentifier().getName());
        System.out.printf("%-25s | %s\n ", "Family", cpu.getProcessorIdentifier().getFamily());
        System.out.printf("%-25s | %s\n " ,"Model", cpu.getProcessorIdentifier().getModel());
        System.out.printf("%-25s | %s\n ", "Processor ID: ", cpu.getProcessorIdentifier().getProcessorID());
        System.out.printf("%-25s | %s\n", "Is Model 64 bit: ", cpu.getProcessorIdentifier().isCpu64bit());
        System.out.printf("%-25s | %s\n", "Microarchitecture: ", cpu.getProcessorIdentifier().getMicroarchitecture());
    }*/
    //OverWritten in CPU Classes
    /*public void printCPU() {
        long[] freqs = cpu.getCurrentFreq();
        long maxfreq = cpu.getMaxFreq();
        double[] cpuLoad = cpu.getProcessorCpuLoad(1000);
        List<PhysicalProcessor> phyproc = cpu.getPhysicalProcessors();
        List<LogicalProcessor> logproc = cpu.getLogicalProcessors();
        System.out.println("\n=== CPU ===");
        System.out.println("Physical Processors: ");
        System.out.printf("%-25s | %s\n", "Physical Processor Count: ", cpu.getPhysicalProcessorCount());

        for (PhysicalProcessor proc : phyproc) {
            System.out.printf("%-25s | %s\n","Processor ID: " , proc.getIdString());
            System.out.printf("%-25s | %s\n","Processor Package Number: " , proc.getPhysicalPackageNumber());
            System.out.printf("%-25s | %s\n","Processor Core ID:" , proc.getPhysicalProcessorNumber());
            System.out.printf("%-25s | %s\n", "Processor Efficiency: " , proc.getEfficiency());
        }
        System.out.println("Logical Processors: ");
        System.out.printf("%-25s | %s\n", " Logical Processor Count: ", cpu.getLogicalProcessorCount());

        for(LogicalProcessor lproc : logproc) {
            System.out.printf("%-25s | %s\n", "NUMA Node: " , lproc.getNumaNode());
            System.out.printf("%-25s | %s\n", "Package Number: " , lproc.getPhysicalPackageNumber());
            System.out.printf("%-25s | %s\n","Processor Number: " , lproc.getPhysicalProcessorNumber());
            System.out.printf("%-25s | %s\n","Processor Group", lproc.getProcessorGroup());
            System.out.printf("%-25s | %s\n","Processor Number", lproc.getProcessorNumber());
        }
        System.out.println("Current Frequency: ");
        for(long freq : freqs) {
            System.out.printf("%-25s | %s\n", "Frequency", FormatUtil.formatHertz(freq));
        }
        System.out.printf("%-25s | %s\n", "Maximum Frequency: ", FormatUtil.formatHertz(maxfreq));
        System.out.println("Ticks: ");
        for(double tick : cpuLoad) {
            System.out.println(tick);
        }
    }*/
    //%-25s | %s\n

    /*public void printMemory() {
        System.out.println("\n=== Memory ===");
        System.out.printf("%-25s | %s GB\n","Total Memory: " , FormatUtil.formatBytes(memory.getTotal()));
        System.out.printf("%-25s | %s GB\n","Available Memory: " , FormatUtil.formatBytes(memory.getAvailable()));
        System.out.printf("%-25s | %s GB\n","Virtual Memory: " , FormatUtil.formatBytes(memory.getVirtualMemory().getSwapTotal()));
        System.out.printf("%-25s | %s GB\n","Page Size: " , FormatUtil.formatBytes(memory.getPageSize()));
        System.out.printf("%-25s | %s\n", "Available Virtual Memory: ", FormatUtil.formatBytes(memory.getVirtualMemory().getSwapUsed()));
    }
    */

    public void printCacheMemory() {
        System.out.println("\n=== Cache Memory ===");
        List<ProcessorCache> caches = cpu.getProcessorCaches();

        for (ProcessorCache cache : caches) {
            System.out.printf("%-25s | %s\n","Cache Level: " , cache.getLevel());
            System.out.printf("%-25s | %s\n","Cache Type: " , cache.getType());
            System.out.printf("%-25s | %s\n","Cache Size: " , FormatUtil.formatBytes(cache.getCacheSize()));
            System.out.printf("%-25s | %s\n","Cache Line Size: " , FormatUtil.formatBytes(cache.getLineSize()));
            System.out.printf("%-25s | %s\n","Cache Associativity: " , cache.getAssociativity());
            System.out.println("====");
        }
    }

    public void printUSBDevices() {
        List<UsbDevice> devices = hardware.getUsbDevices(true);
        System.out.println("\n=== USB Devices ===");
        for(UsbDevice device : devices) {
            System.out.printf("%-25s | %s\n", "Name: ", device.getName());
            System.out.printf("%-25s | %s\n", "Product ID: ", device.getProductId());
            System.out.printf("%-25s | %s\n", "Serial Number: ", device.getSerialNumber() == null ? "N/A" : device.getSerialNumber());
            System.out.printf("%-25s | %s\n", "Unique Device ID: ", device.getUniqueDeviceId());
            System.out.printf("%-25s | %s\n", "Vendor: ", device.getVendor());
            System.out.printf("%-25s | %s\n", "Vendor ID: ", device.getVendorId());
        }
    }

    public void printDisks() {
        List<HWDiskStore> disks = hardware.getDiskStores();
        System.out.println("\n=== Disks ===");
        for(HWDiskStore disk : disks) {
            System.out.printf("%-25s | %s\n", "Current Queue Length: ", disk.getCurrentQueueLength());
            System.out.printf("%-25s | %s\n", "Model: ", disk.getModel());
            System.out.printf("%-25s | %s\n", "Name: ", disk.getName());
            System.out.printf("%-25s | %s\n", "Partitions: ", disk.getPartitions());
            System.out.printf("%-25s | %s\n", "Read Bytes: ", formatBytes(disk.getReadBytes()));
            System.out.printf("%-25s | %s\n", "Reads: ", disk.getReads());
            System.out.printf("%-25s | %s\n", "Size: ", formatBytes(disk.getSize()));
            System.out.printf("%-25s | %s milliseconds\n", "Transfer Time: ", disk.getTransferTime());
            System.out.printf("%-25s | %s\n", "Write Bytes: ", disk.getWriteBytes());
            System.out.printf("%-25s | %s\n", "Writes: ", disk.getWrites());
        }
    }


    public void printSysUtil() {
        //printSystemSpecifics();
        //printCPU();
        //printMemory();
        printCacheMemory();
        printUSBDevices();
        printDisks();
    }

}
class CPUGeneric extends ProcessorSpecs{
    CPUGeneric(){
        super();
    }
    protected long[] freqs = cpu.getCurrentFreq();
    protected long maxfreq = cpu.getMaxFreq();
    protected double[] cpuLoad = cpu.getProcessorCpuLoad(1000);
    protected List<PhysicalProcessor> physproc = cpu.getPhysicalProcessors();
    protected List<LogicalProcessor> logproc = cpu.getLogicalProcessors();
    public String getCurrentFrequency(int i){
        return FormatUtil.formatHertz(freqs[i]);
    }
    public String getMaxFrequency(int i){
        return FormatUtil.formatHertz(maxfreq);
    }
    //I need to add ticks here but will do tomorrow because this is killing me slowly
}
class PhysicalCPU extends CPUGeneric {
    PhysicalCPU(){
        super();
    }
    public int physicalProcessorCount(){
        return cpu.getPhysicalProcessorCount();
    }
    public String getIdString(int i){
        return physproc.get(i).getIdString();
    }
    public int getPackageNumber(int i){
        return physproc.get(i).getPhysicalPackageNumber();
    }
    public int processorEfficiency(int i){
        return physproc.get(i).getEfficiency();
    }
    public void testData(){
        System.out.printf("%-25s | %s\n","Processor ID: " , getIdString(0));
        System.out.printf("%-25s | %s\n","Processor Package Number: " , getPackageNumber(0));
        System.out.printf("%-25s | %s\n","Processor Core ID:" , physicalProcessorCount());
        System.out.printf("%-25s | %s\n", "Processor Efficiency: " , processorEfficiency(0));
        /*
        System.out.println(physicalProcessorCount());
        System.out.println(getIdString(0));
        System.out.println(getPackageNumber(0));
        System.out.println(processorEfficiency(0));
        */
        System.out.println(getCurrentFrequency(0));
        System.out.println(getMaxFrequency(0));
    }
}
class LogicalCPU extends CPUGeneric {
    LogicalCPU(){
        super();
    }
    public int logicalProcessorCount(){
        return cpu.getLogicalProcessorCount();
    }
    public int NumaNode(int i){
        return logproc.get(i).getNumaNode();
    }
    //Not sure about these two functions below. Are you sure these refer to logical processors and not physical ones?
    public int packageNumber(int i){
        return logproc.get(i).getPhysicalPackageNumber();
    }
    public int physicalProcessorNumber(int i){
        return logproc.get(i).getPhysicalProcessorNumber();
    }
    public int processorGroup(int i){
        return logproc.get(i).getProcessorGroup();
    }
    public int processorNumber(int i){
        return logproc.get(i).getProcessorNumber();

    }
    public void testData(){
        System.out.printf("%-25s | %s\n", "NUMA Node: " , NumaNode(0));
        System.out.printf("%-25s | %s\n", "Package Number: " , packageNumber(0));
        System.out.printf("%-25s | %s\n","Processor Number: " , physicalProcessorNumber(0));
        System.out.printf("%-25s | %s\n","Processor Group", processorGroup(0));
        System.out.printf("%-25s | %s\n","Processor Number", processorNumber(0));
        /*
        System.out.println(logicalProcessorCount());
        System.out.println(NumaNode(0));
        System.out.println(packageNumber(0));
        System.out.println(physicalProcessorNumber(0));
        System.out.println(processorGroup(0));
        System.out.println(processorNumber(0));
        */
        System.out.println(getCurrentFrequency(0));
        System.out.println(getMaxFrequency(0));
    }
}
class ProcessorSpecs extends OshiMethod{
    ProcessorSpecs(){
        super();
    }
    public String name(){
        return cpu.getProcessorIdentifier().getName();
    }
    public String family(){
        return cpu.getProcessorIdentifier().getFamily();
    }
    public String model(){
        return cpu.getProcessorIdentifier().getModel();
    }
    public String id(){
        return cpu.getProcessorIdentifier().getProcessorID();
    }
    public boolean is64Bit(){
        return cpu.getProcessorIdentifier().isCpu64bit();
    }
    public String microarchitecture(){
        return cpu.getProcessorIdentifier().getMicroarchitecture();
    }
    public void testData(){
        System.out.printf("%-25s | %s\n","Processor Name: " , name());
        System.out.printf("%-25s | %s\n","Processor Family: " , family());
        System.out.printf("%-25s | Processor Model: " , model());
        System.out.printf("%-25s | Processor ID: " , id());
        System.out.printf("%-25s | 64 Bit: " , is64Bit());
        System.out.printf("%-25s | Microarchitecture: " , microarchitecture());
    }
}
class SysMemory extends OshiMethod{

    SysMemory(){
        super();
    }
    public long totalMemory(){
        return memory.getTotal();
    }
    public long availableMemory(){
        return memory.getAvailable();
    }
    public long freeMemory(){
        return memory.getTotal()-memory.getAvailable();
    }
    public long virtualMemory(){
        return memory.getVirtualMemory().getSwapTotal();
    }
    public long pageSize(){
        return memory.getPageSize();
    }
    public long availableVirtualMemory(){
        return memory.getVirtualMemory().getSwapUsed();
    }
    public void testData(){
        System.out.println();
        System.out.println("=== System Memory ===");
        System.out.println("Total Physical Memory     : " + formatBytes(totalMemory()));
        System.out.println("Available Physical Memory : " + formatBytes(availableMemory()));
        System.out.println("Used Physical Memory      : " + formatBytes(freeMemory()));
        System.out.println("Total Virtual Memory (Swap): " + formatBytes(virtualMemory()));
        System.out.println("Used Virtual Memory (Swap) : " + formatBytes(availableVirtualMemory()));
        System.out.println("Memory Page Size          : " + formatBytes(pageSize()));
    }
}
/* Used Chatgpt to check for any logic issues or improvements to current methods. -May implement this later
 public void printUSBTree(UsbDevice device, int indent) {
    String prefix = " ".repeat(indent * 2);
    System.out.printf("%s%s (Vendor: %s, Product: %s)\n",
            prefix, device.getName(), device.getVendor(), device.getProductId());
    for (UsbDevice child : device.getConnectedDevices()) {
        printUSBTree(child, indent + 1);
    }
}

// Usage:
List<UsbDevice> devices = hardware.getUsbDevices(true);
for (UsbDevice device : devices) {
    printUSBTree(device, 0);
} */
