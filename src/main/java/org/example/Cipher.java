package org.example;

public class Cipher {
    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public Cipher() {
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    }

    public String encrypt(String text, int shift) {
        return text;
    }

    public String decrypt(String encryptedText, int shift) {
        return encryptedText;
    }

}
