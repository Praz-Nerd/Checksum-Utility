package ro.praz.main;


import ro.praz.crypto.ByteDigester;
import ro.praz.img.Photo;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class Main {
    private static final int BYTES_READ = 256;
    public static void main(String[] args) {
        try(Photo p = new Photo("test/alien.jpg")) {
            ByteDigester byteDigester = new ByteDigester("MD5");
            byte[] data = p.readNextBytes(BYTES_READ);
            while(data.length == BYTES_READ){
                byteDigester.addBytes(data);
                data = p.readNextBytes(BYTES_READ);
            }
            System.out.println("Photo at " + p.getPath() + " has hash "+ byteDigester.getHex());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}