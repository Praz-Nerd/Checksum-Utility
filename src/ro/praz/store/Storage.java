package ro.praz.store;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static Map<String, List<Path>> photoMap = new HashMap<>();
    public static void printMap(){
        for(String hash : photoMap.keySet()){
            System.out.println("For hash " + hash + " : " + photoMap.get(hash));
        }
    }
}
