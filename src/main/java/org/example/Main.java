package org.example;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.encrypt("Kris it's my name.", 32));
        System.out.println(cipher.decrypt("Ovmwcmxdwcq!creqi ", 100));
        System.out.println(cipher.decryptByBruteForce("Ovmw"));
    }
}