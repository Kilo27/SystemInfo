import oshi.hardware.CentralProcessor;
import oshi.util.FormatUtil;

import java.util.List;

public class CPUGeneric extends ProcessorSpecs{
    CPUGeneric(){
        super();
    }
    protected static long[] freqs = cpu.getCurrentFreq();
    protected static long maxfreq = cpu.getMaxFreq();
    protected static double[] cpuLoad = cpu.getProcessorCpuLoad(1000);
    protected static List<CentralProcessor.PhysicalProcessor> physproc = cpu.getPhysicalProcessors();
    protected static List<CentralProcessor.LogicalProcessor> logproc = cpu.getLogicalProcessors();
    public static String getCurrentFrequency(int i){
        return FormatUtil.formatHertz(freqs[i]);
    }
    public static String getMaxFrequency(){
        return FormatUtil.formatHertz(maxfreq);
    }
    //I need to add ticks here but will do tomorrow because this is killing me slowly
}