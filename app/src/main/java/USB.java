package org.example;

import oshi.hardware.UsbDevice;

import java.util.List;

public class USB extends OshiMethod {
    public List<UsbDevice> getParentLevelUsbDevices() {
        return hardware.getUsbDevices(false);
    }
    public List<UsbDevice> getChildLevelUsbDevices(UsbDevice parent) {
        return parent.getConnectedDevices();
    }
    public void checkChildLevelUsbDevices(UsbDevice parent) {
        List<UsbDevice> children = getChildLevelUsbDevices(parent);
        if(children.isEmpty()) {
            System.out.println("Parent " + parent.getName() + " has no children");
        }
        else{
            for(UsbDevice child : children) {
                System.out.println("Child: " + child.getName() + " Product ID: " + child.getProductId());
            }
        }
    }
}