package org.example

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;


class OperatingSystem {

    public SystemInfo systeminfo;
    public OperatingSystem os;

    OperatingSystem() {
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
    public OperatingSystemVersion versionInfo() {
        return os.getVersionInfo().getVersion();
    }
//file system
    public FileSystem fileSystem() {
        return os.getFileSystem();
    }
}
