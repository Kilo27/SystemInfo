public class PhysicalCPU extends CPUGeneric {
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
        System.out.println(getMaxFrequency());
    }
}
