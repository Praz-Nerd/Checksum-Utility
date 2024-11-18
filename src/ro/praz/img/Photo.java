package ro.praz.img;

import ro.praz.crypto.ByteDigester;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Photo {
    private final Path path;
    private final ByteDigester byteDigester;

    private String hash;

    public Path getPath() {
        return path;
    }

    public Photo(String p) throws InvalidPathException, NoSuchAlgorithmException, IOException {
        byteDigester = new ByteDigester("MD5");
        path = Paths.get(p).toAbsolutePath();
        if(!Files.exists(path)){
            throw new IllegalArgumentException("Invalid path");
        }
        computeMD5(256);
    }

    public String getHash(){
        return hash;
    }

    public void computeMD5(int len) throws IOException {
        FileInputStream fis = new FileInputStream(path.toFile());
        byte[] data = fis.readNBytes(len);

        do{
            byteDigester.addBytes(data);
            data = fis.readNBytes(len);
        }while (data.length == len);
        fis.close();
        hash = byteDigester.getHex();
    }

    public void addToMap(Map<String, List<Path>> photoMap){
        if(photoMap.containsKey(hash)){
            List<Path> l = photoMap.get(hash);
            l.add(path);
        }
        else{
            List<Path> l = new ArrayList<>();
            l.add(path);
            photoMap.put(hash, l);
        }
    }

}
