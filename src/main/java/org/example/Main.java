package org.example;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.encrypt("Hi, Kris here! Do you like java?.", 100));
        System.out.println(cipher.decrypt("Lm'cOvmwcliviacHsc!sycpmoicnezeb", 100));
        System.out.println(cipher.decryptByBruteForce("Lm'cOvmwcliviacHsc!sycpmoicnezeb"));
        System.out.println("=======");
        System.out.println(cipher.decryptByStatistics("Lm'cOvmwcliviacHsc!sycpmoicnezeb"));
    }
}