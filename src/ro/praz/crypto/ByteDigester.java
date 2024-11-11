package ro.praz.crypto;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ByteDigester {
    private final MessageDigest messageDigest;

    public ByteDigester(String algorithm) throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance(algorithm);
    }
    public void addBytes(byte[]data){
        this.messageDigest.update(data);
    }
    public String getHex(){
        return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
    }
//    public static String getMD5(byte[] data) throws NoSuchAlgorithmException {
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        messageDigest.update(data);
//        return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
//    }
}
