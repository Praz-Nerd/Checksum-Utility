package ro.praz.crypto;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digester {
    public static String getMD5(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(s.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
    }

    public static String getMD5(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(data);
        return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
    }
}
