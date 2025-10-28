package org.example;

import oshi.hardware.NetworkIF;

import java.util.ArrayList;
import java.util.List;

public class Network extends OshiMethod {

    public ArrayList<NetInterface> doTheShit() {

        // get list of net interfaces from hardware
        List<NetworkIF> iFList = hardware.getNetworkIFs();

        ArrayList<NetInterface> netInterfaces = new ArrayList<NetInterface>();

        for (NetworkIF IF : iFList) {

            // clear existing attributes
            IF.updateAttributes();

            // append to workable list
            netInterfaces.add(new NetInterface(IF));

        }

        return netInterfaces;
    }

    public void testData() {

        System.out.println(doTheShit());

    }

}

class NetInterface {

    protected String name;
    protected String displayName;
    protected String macaddr;
    protected String[] ipv4addrList;
    protected String[] ipv6addrList;
    protected Short[] subnetMasks;
    protected NetworkIF.IfOperStatus operStatus;
    protected boolean connectorPresent;
    protected long timeStamp;
    protected long speed;
    protected long bytesSent;
    protected long bytesReceived;
    protected long packetsSent;
    protected long packetsReceived;
    protected long packetDrops;
    protected long packetCollisions;
    protected long outErrors;

    public NetInterface(NetworkIF IF) {
        this.name = IF.getName();
        this.displayName = IF.getDisplayName();
        this.macaddr = IF.getMacaddr();
        this.ipv4addrList = IF.getIPv4addr();
        this.ipv6addrList = IF.getIPv6addr();
        this.subnetMasks = IF.getSubnetMasks();
        this.operStatus = IF.getIfOperStatus();
        this.connectorPresent = IF.isConnectorPresent();
        this.timeStamp = IF.getTimeStamp();
        this.speed = IF.getSpeed();
        this.bytesSent = IF.getBytesSent();
        this.bytesReceived = IF.getBytesRecv();
        this.packetsSent = IF.getPacketsSent();
        this.packetsReceived = IF.getPacketsRecv();
        this.packetDrops = IF.getInDrops();
        this.packetCollisions = IF.getCollisions();
        this.outErrors = IF.getOutErrors();
    }

}
