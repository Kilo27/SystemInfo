
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.OperatingSystem;


class OSInfo {

    public SystemInfo systeminfo;
    public OperatingSystem os;

    public OSInfo() {
        systeminfo = new SystemInfo();
        os = systeminfo.getOperatingSystem();
    }    
//Returns Family of OS
    public String family() {
        return os.getFamily();
    }
//returns manfacturer
    public String manufacturer() {
        return os.getManufacturer();
    }
//returns os version 
    public String versionInfo() {
        return os.getVersionInfo().getVersion();
    }
//file system
    public FileSystem fileSystem() {
        return os.getFileSystem();
    }
//Current process
    public OSProcess currentProcess() {
        return os.getCurrentProcess();
    }

    public OSThread currentThread() {return os.getCurrentThread();
    }
}
