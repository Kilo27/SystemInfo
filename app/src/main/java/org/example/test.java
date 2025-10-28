package org.example;

public class test {
    public static void main(String[] args) {
        ProcessorSpecs specs = new ProcessorSpecs();
        OshiMethod oshi = new OshiMethod();
        LogicalCPU threadCpu = new LogicalCPU();
        PhysicalCPU physicalCpu = new PhysicalCPU();
        SysMemory memory = new SysMemory();

        specs.testData();
        physicalCpu.testData();
        threadCpu.testData();
        memory.testData();
        oshi.printSysUtil();
    }
}
