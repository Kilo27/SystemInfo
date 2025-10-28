import oshi.hardware.CentralProcessor;

import java.util.List;

public class Cache extends OshiMethod{
    public List<CentralProcessor.ProcessorCache> caches;
    public Cache() {
        super();
        this.caches = cpu.getProcessorCaches();
    }
    public int getCacheLevel(int i){
        return caches.get(i).getLevel();
    }
    public CentralProcessor.ProcessorCache.Type type(int i){
        return caches.get(i).getType();
    }
    public int size(int i){
        return caches.get(i).getCacheSize();
    }
    public int lineSize(int i){
        return caches.get(i).getLineSize();
    }
    public int associativity(int i){
        return caches.get(i).getAssociativity();
    }
    public void testData(){
        System.out.println("\n=== Cache Memory ===");
        System.out.printf("%-25s | %s\n","Cache Level: " , getCacheLevel(0));
        System.out.printf("%-25s | %s\n","Cache Type: " , type(0));
        System.out.printf("%-25s | %s\n","Cache Size: " , formatBytes(size(0)));
        System.out.printf("%-25s | %s\n","Cache Line Size: " , formatBytes(lineSize(0)));
        System.out.printf("%-25s | %s\n","Cache Associativity: " , associativity(0));
        System.out.println("====");
    }
}
