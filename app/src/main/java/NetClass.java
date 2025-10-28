import oshi.hardware.NetworkIF;

import java.util.ArrayList;
import java.util.List;

public class NetClass extends OshiMethod {

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
}

class NetInterface {

    protected String name;
    protected String displayName;
    protected String macAddr;
    protected String[] ipv4AddrList;
    protected String[] ipv6AddrList;
    protected NetworkIF.IfOperStatus operStatus;
    protected boolean connectorPresent;
    protected long speed;
    protected long bytesSent;
    protected long packetsSent;
    protected long bytesReceived;
    protected long packetsReceived;
    protected long outErrors;

    public NetInterface(NetworkIF IF) {
        this.name = IF.getName();
        this.displayName = IF.getDisplayName();
        this.macAddr = IF.getMacaddr();
        this.ipv4AddrList = IF.getIPv4addr();
        this.ipv6AddrList = IF.getIPv6addr();
        this.operStatus = IF.getIfOperStatus();
        this.connectorPresent = IF.isConnectorPresent();
        this.speed = IF.getSpeed();
        this.bytesSent = IF.getBytesSent();
        this.packetsSent = IF.getPacketsSent();
        this.bytesReceived = IF.getBytesRecv();
        this.packetsReceived = IF.getPacketsRecv();
        this.outErrors = IF.getOutErrors();
    }

}
