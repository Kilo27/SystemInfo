package org.example;

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


