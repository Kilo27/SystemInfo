import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ProcessorSpecs specs = new ProcessorSpecs();
        OshiMethod oshi = new OshiMethod();
        LogicalCPU threadCpu = new LogicalCPU();
        PhysicalCPU physicalCpu = new PhysicalCPU();
        SysMemory memory = new SysMemory();
        Network network = new Network();
        specs.testData();
        physicalCpu.testData();
        threadCpu.testData();
        memory.testData();
        oshi.printSysUtil();
        network.testData();
        List<USB.USBInfo>  usbList=USB.getAllUsbInfo();
        System.out.println(usbList);
        System.out.println(usbList.getFirst().name);


    }
}
