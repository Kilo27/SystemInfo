import oshi.hardware.UsbDevice;

import java.util.List;

public class USB extends OshiMethod {
    public List<UsbDevice> getParentLevelUsbDevices() {
        return hardware.getUsbDevices(false);
    }
    public List<UsbDevice> getChildLevelUsbDevices(UsbDevice parent) {
        return parent.getConnectedDevices();
    }
     /*
     * Recursively prints all child USB devices of the given parent device.
     * 
     * If a parent has no children, a message is printed. Otherwise,
     * each child’s name and product ID are displayed, and the method
     * is called again for that child — allowing full tree traversal.
     */
    public void checkChildLevelUsbDevices(UsbDevice parent) {
        List<UsbDevice> children = getChildLevelUsbDevices(parent);
        if(children.isEmpty()) {
            System.out.println("Parent " + parent.getName() + " has no children");
        }
        else{
            for(UsbDevice child : children) {
                System.out.println("Child: " + child.getName() + " Product ID: " + child.getProductId());
                checkChildLevelUsbDevices(child);
                /* Recursive call — traverses grandchildren, great-grandchildren, etc.*/
            }
        }
    }
}
