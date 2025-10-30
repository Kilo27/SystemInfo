import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

import java.util.List;

public class LocalGraphics {

    public SystemInfo systeminfo;
    public HardwareAbstractionLayer hal;
    public List<GraphicsCard> gpus;

    public LocalGraphics() {
        systeminfo = new SystemInfo();
        hal = systeminfo.getHardware();
        gpus = hal.getGraphicsCards();
    }
    /* Returns "N/A" if the string is null or empty */
    public String stringCheck(String value) {
        return (value == null || value.isEmpty() ? "N/A" : value);
    }
    //Returns the name of the gpu at index i.
    public String graphicsName(int i) {
        String name = gpus.get(i).getName();
        return stringCheck(name);
    }
    //Returns the device ID for the gpu at index i.
    public String graphicsDeviceId(int i) {
        String id = gpus.get(i).getDeviceId();
        return stringCheck(id);
    }
    //Returns the vendor
    public String graphicsVendor(int i) {
        String vendor = gpus.get(i).getVendor();
        return stringCheck(vendor);
    }
    //Returns the vram bytes for gpu at index i
    public String vramBytes(int i) {
        long vram = gpus.get(i).getVRam();
        return (vram <= 0) ? "N/A" : FormatUtil.formatBytes(vram);
        
    }
    //Returns version info for gpu at index i
    public String graphicsVersionInfo(int i) {
        String gpuVersionInfo = gpus.get(i).getVersionInfo();
        return stringCheck(gpuVersionInfo);
    }
    //Returns gpu count
    public int gpuCount() {
        return gpus.size();
    }
}
