public class LogicalCPU extends CPUGeneric {
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
