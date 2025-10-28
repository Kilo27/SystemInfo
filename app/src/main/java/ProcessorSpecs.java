import oshi.hardware.CentralProcessor;
import oshi.util.FormatUtil;

import java.util.List;

public class ProcessorSpecs extends OshiMethod{
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
abstract class CPUGeneric extends ProcessorSpecs{
    CPUGeneric(){
        super();
    }
    protected long[] freqs = cpu.getCurrentFreq();
    protected long maxfreq = cpu.getMaxFreq();
    protected double[] cpuLoad = cpu.getProcessorCpuLoad(1000);
    protected List<CentralProcessor.PhysicalProcessor> physproc = cpu.getPhysicalProcessors();
    protected List<CentralProcessor.LogicalProcessor> logproc = cpu.getLogicalProcessors();
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
