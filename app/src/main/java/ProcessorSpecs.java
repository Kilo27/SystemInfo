public class ProcessorSpecs extends OshiMethod{
    ProcessorSpecs(){
        super();
    }
    public static String name(){
        return cpu.getProcessorIdentifier().getName();
    }
    public static String family(){
        return cpu.getProcessorIdentifier().getFamily();
    }
    public static String model(){
        return cpu.getProcessorIdentifier().getModel();
    }
    public static String id(){
        return cpu.getProcessorIdentifier().getProcessorID();
    }
    public static boolean is64Bit(){
        return cpu.getProcessorIdentifier().isCpu64bit();
    }
    public static String microarchitecture(){
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

