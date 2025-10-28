package org.example;

import oshi.hardware.NetworkIF;
import java.util.List;

public class NetClass extends OshiMethod {


    public void doTheShit() {

        // get list of net interfaces from hardware
        List<NetworkIF> iFList = hardware.getNetworkIFs();

        for (NetworkIF IF : iFList) {

            // clear existing attributes
            IF.updateAttributes();

            System.out.println("Bytes sent: " + IF.getBytesSent());
            System.out.println("Bytes recv: " + IF.getBytesRecv());
            System.out.println("Packets sent: " + IF.getPacketsSent());
            System.out.println("Packets recv: " + IF.getPacketsRecv());
            System.out.println("Speed (bps): " + IF.getSpeed());
            System.out.println("Input errors: " + IF.getInErrors());
            System.out.println("Output errors: " + IF.getOutErrors());
            System.out.println("Is connector present: " + IF.isConnectorPresent());
            System.out.println("Operational status: " + IF.getIfOperStatus());
            System.out.println("-----");

        }
    }
}
