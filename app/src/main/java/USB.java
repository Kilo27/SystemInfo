
import oshi.hardware.UsbDevice;
import java.util.ArrayList;
import java.util.List;

public class USB extends OshiMethod {
    USB(){
        super();
    }
    public static List<UsbDevice> getParentLevelUsbDevices() {
        return hardware.getUsbDevices(false);
    }

    public List<UsbDevice> getChildLevelUsbDevices(UsbDevice parent) {
        return parent.getConnectedDevices();
    }

    // A helper data model for GUI display
    public static class USBInfo {
        public String name;
        public String vendor;
        public String vendorId;
        public String productId;
        public String serialNumber;
        public boolean connected;
        public String uniqueId;
        public List<USBInfo> children = new ArrayList<>();
    }

    // Build a tree of UsbInfo objects
    public static USBInfo buildUsbInfoTree(UsbDevice device) {
        USBInfo info = new USBInfo();
        info.name = device.getName();
        info.vendor = device.getVendor();
        info.vendorId = device.getVendorId();
        info.productId = device.getProductId();
        info.serialNumber = device.getSerialNumber();
        //info.connected = device.isConnected();
        info.uniqueId = device.getUniqueDeviceId();

        for (UsbDevice child : device.getConnectedDevices()) {
            info.children.add(buildUsbInfoTree(child));
        }
        return info;
    }

    public static List<USBInfo> getAllUsbInfo() {
        List<USBInfo> list = new ArrayList<>();
        for (UsbDevice parent : getParentLevelUsbDevices()) {
            list.add(buildUsbInfoTree(parent));
        }
        return list;
    }
}
