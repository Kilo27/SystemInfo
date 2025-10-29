import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.HardwareAbstractionLayer;
public class CPUUsage {
	private static SystemInfo si = new SystemInfo();
	private static HardwareAbstractionLayer hal = si.getHardware();
	private static CentralProcessor cpu = hal.getProcessor();
	static long[] prevTicks = new long[TickType.values().length];
	public static double getCPU()
	{
		double cpuLoad = cpu.getSystemCpuLoadBetweenTicks( prevTicks ) * 100;
		prevTicks = cpu.getSystemCpuLoadTicks();
		System.out.println("cpuLoad : " + cpuLoad);
		return cpuLoad;
	}
}