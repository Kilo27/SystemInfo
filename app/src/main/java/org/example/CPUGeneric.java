package org.example;

import oshi.hardware.CentralProcessor;
import oshi.util.FormatUtil;

import java.util.List;

public class CPUGeneric extends ProcessorSpecs{
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