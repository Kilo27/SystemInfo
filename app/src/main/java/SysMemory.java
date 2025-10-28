public class SysMemory extends OshiMethod{

    SysMemory(){
        super();
    }
    public long totalMemory(){
        return memory.getTotal();
    }
    public long availableMemory(){
        return memory.getAvailable();
    }
    public long usedMemory(){
        return memory.getTotal()-memory.getAvailable();
    }
    public long virtualMemory(){
        return memory.getVirtualMemory().getSwapTotal();
    }
    public long pageSize(){
        return memory.getPageSize();
    }
    public long availableVirtualMemory(){
        return memory.getVirtualMemory().getSwapUsed();
    }
    public void testData(){
        System.out.println();
        System.out.println("=== System Memory ===");
        System.out.println("Total Physical Memory     : " + formatBytes(totalMemory()));
        System.out.println("Available Physical Memory : " + formatBytes(availableMemory()));
        System.out.println("Used Physical Memory      : " + formatBytes(usedMemory()));
        System.out.println("Total Virtual Memory (Swap): " + formatBytes(virtualMemory()));
        System.out.println("Used Virtual Memory (Swap) : " + formatBytes(availableVirtualMemory()));
        System.out.println("Memory Page Size          : " + formatBytes(pageSize()));
    }
}