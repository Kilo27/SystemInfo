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

    private SystemInfo systeminfo;
    private HardwareAbstractionLayer hardware;
    private CentralProcessor cpu;
    private GlobalMemory memory;


    public OshiMethod() {
        initSystemInfo();
        initHardware();
        initCentralProcessor();
        initMemory();
        initSensors();
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

    public void printSystemSpecifics() {
        System.out.println("\n=== System Specifications ===");
        System.out.printf("%-25s | %s\n ", "Name", cpu.getProcessorIdentifier().getName());
        System.out.printf("%-25s | %s\n ", "Family", cpu.getProcessorIdentifier().getFamily());
        System.out.printf("%-25s | %s\n " ,"Model", cpu.getProcessorIdentifier().getModel());
        System.out.printf("%-25s | %s\n ", "Processor ID: ", cpu.getProcessorIdentifier().getProcessorID());
        System.out.printf("%-25s | %s\n", "Is Model 64 bit: ", cpu.getProcessorIdentifier().isCpu64bit());
        System.out.printf("%-25s | %s\n", "Microarchitecture: ", cpu.getProcessorIdentifier().getMicroarchitecture());
    }

    public void printCPU() {
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
    }
    //%-25s | %s\n
    public void printMemory() {
        System.out.println("\n=== Memory ===");
        System.out.printf("%-25s | %s GB\n","Total Memory: " , FormatUtil.formatBytes(memory.getTotal()));
        System.out.printf("%-25s | %s GB\n","Available Memory: " , FormatUtil.formatBytes(memory.getAvailable()));
        System.out.printf("%-25s | %s GB\n","Virtual Memory: " , FormatUtil.formatBytes(memory.getVirtualMemory().getSwapTotal()));
        System.out.printf("%-25s | %s GB\n","Page Size: " , FormatUtil.formatBytes(memory.getPageSize()));
        System.out.printf("%-25s | %s\n", "Available Virtual Memory: ", FormatUtil.formatBytes(memory.getVirtualMemory().getSwapUsed()));
    }

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

    public void printUSBdevices() {
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
            System.out.printf("%-25s | %s\n", "Read Bytes: ", disk.getReadBytes());
            System.out.printf("%-25s | %s\n", "Reads: ", disk.getReads());
            System.out.printf("%-25s | %s\n", "Size: ", disk.getSize());
            System.out.printf("%-25s | %s milliseconds\n", "Transfer Time: ", disk.getTransferTime());
            System.out.printf("%-25s | %s\n", "Write Bytes: ", disk.getWriteBytes());
            System.out.printf("%-25s | %s\n", "Writes: ", disk.getWrites());
        }
    }


    public void printSysUtil() {
        printSystemSpecifics();
        printCPU();
        printMemory();
        printCacheMemory();
        printUSBdevices();
        printDisks();
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
