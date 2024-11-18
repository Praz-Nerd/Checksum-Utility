package ro.praz.main;


import ro.praz.crypto.ByteDigester;
import ro.praz.img.Photo;
import ro.praz.store.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class Main {
    private static final int BYTES_READ = 256;
    public static void main(String[] args) {

        try {
            Object[] arr =  Files.walk(Path.of("test"))
                    .filter(p->!Files.isDirectory(p))
                    .map(p-> {
                        try {
                            return new Photo(p.toString());
                        } catch (NoSuchAlgorithmException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).toArray();
            for(Object o : arr){
                Photo p = (Photo)o;
                p.addToMap(Storage.photoMap);
            }

            Storage.printMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}