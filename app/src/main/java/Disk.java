import oshi.hardware.HWDiskStore;
import oshi.util.FormatUtil;

import java.util.List;

/*
  Utility class to access disk (HDD/SSD) information using OSHI.
 */

public class Disk extends OshiMethod {
    public List<HWDiskStore> disks;

    public Disk() {
        super();
        disks = hardware.getDiskStores();
    }
    //Returns current queue length at index i.
    public long currentQueue(int i) {
        return disks.get(i).getCurrentQueueLength();
    }
    //Returns disk model at index i.
    public String diskModel(int i) {
        return disks.get(i).getModel();
    }
    //Returns disk name at index i.
    public String diskName(int i) {
        return disks.get(i).getName();
    }
    //Returns a list of partitions for disk at index i.
    public List<oshi.hardware.HWPartition> diskPart(int i) {
        return disks.get(i).getPartitions();
    }
    //Returns the read bytes for a disk at index i.
    public String readBytes(int i) {
        return FormatUtil.formatBytes(disks.get(i).getReadBytes());
    }
    public long readBytesFormatNumbers(int i){
        System.out.printf("Read Bytes: %s\n",FormatUtil.formatBytes(disks.get(i).getReadBytes()));
        return disks.get(i).getReadBytes();
    }
    public long writeBytesFormatNumbers(int i){
        System.out.printf("Written Bytes: %s\n",FormatUtil.formatBytes(disks.get(i).getWriteBytes()));
        return disks.get(i).getWriteBytes();
    }

    public long reads(int i)  {
        return disks.get(i).getReads();
    }
    //Returns the size of a disk at index i.
    public String size(int i) {
        return FormatUtil.formatBytes(disks.get(i).getSize());
    }
    /* Returns the transfer time for disk at index i. (Transfer time - it is the actual duration that it takes to read or write data between thr disk and the computer's main memory once the read / write head is aligned.)*/
    public String transferTime(int i) {
        return disks.get(i).getTransferTime() + " milliseconds";
    }
    public long transferTimeFormatNumbers(int i) {
        return disks.get(i).getTransferTime();
    }

    public String writeBytes(int i) {
        return FormatUtil.formatBytes(disks.get(i).getWriteBytes());
    }
    //Returns the number of writes for a disk at index i.
    public long writes(int i) {
        return disks.get(i).getWrites();
    }
    //Test to confirm methods work as intended.
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
