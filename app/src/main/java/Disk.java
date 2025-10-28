import oshi.hardware.HWDiskStore;
import oshi.util.FormatUtil;

import java.util.List;

public class Disk extends OshiMethod {
    public List<HWDiskStore> disks;

    public Disk() {
        super();
        disks = hardware.getDiskStores();
    }

    public long currentQueue(int i) {
        return disks.get(i).getCurrentQueueLength();
    }

    public String diskModel(int i) {
        return disks.get(i).getModel();
    }

    public String diskName(int i) {
        return disks.get(i).getName();
    }
    public List<oshi.hardware.HWPartition> diskPart(int i) {
        return disks.get(i).getPartitions();
    }
    public String readBytes(int i) {
        return FormatUtil.formatBytes(disks.get(i).getReadBytes());
    }

    public long reads(int i)  {
        return disks.get(i).getReads();
    }

    public String size(int i) {
        return FormatUtil.formatBytes(disks.get(i).getSize());
    }

    public String transferTime(int i) {
        return disks.get(i).getTransferTime() + " milliseconds";
    }

    public String writeBytes(int i) {
        return FormatUtil.formatBytes(disks.get(i).getWriteBytes());
    }

    public long writes(int i) {
        return disks.get(i).getWrites();
    }
    public void testData(){
        System.out.printf("%-25s | %s\n", "Current Queue Length: ", currentQueue(0));
        System.out.printf("%-25s | %s\n", "Model: ", diskModel(0));
        System.out.printf("%-25s | %s\n", "Name: ", diskName(0));
        System.out.printf("%-25s | %s\n", "Partitions: ", diskPart(0));
        System.out.printf("%-25s | %s\n", "Read Bytes: ", readBytes(0));
        System.out.printf("%-25s | %s\n", "Reads: ", reads(0));
        System.out.printf("%-25s | %s\n", "Size: ", size(0));
        System.out.printf("%-25s | %s milliseconds\n", "Transfer Time: ", transferTime(0));
        System.out.printf("%-25s | %s\n", "Write Bytes: ", writeBytes(0));
        System.out.printf("%-25s | %s\n", "Writes: ", writes(0));
    }
}
