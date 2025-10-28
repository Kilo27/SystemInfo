import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

import java.util.List;

public class Graphics {

    public SystemInfo systeminfo;
    public HardwareAbstractionLayer hal;
    public List<GraphicsCard> gpus;

    public Graphics() {
        systeminfo = new SystemInfo();
        hal = systeminfo.getHardware();
        gpus = hal.getGraphicsCards();
    }

    public String graphicsName(int i) {
        return  gpus.get(i).getName();
    }
    public String graphicsDeviceId(int i) {
        return gpus.get(i).getDeviceId();
    }
    public String graphicsVendor(int i) {
        return gpus.get(i).getVendor();
    }
    public String vramBytes(int i) {
        return FormatUtil.formatBytes(gpus.get(i).getVRam());
    }
    public String graphicsVersionInfo(int i) {
        return gpus.get(i).getVersionInfo();
    }
    public int gpuCount() {
        return gpus.size();
    }
}
