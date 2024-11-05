package ro.praz.main;

import ro.praz.crypto.Digester;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        try {
            System.out.println(Digester.getMD5("Hello World"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}