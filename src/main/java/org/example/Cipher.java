package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {
    private final List<Character> alphabet;

    public Cipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public Cipher() {
        this.alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '!', '?', ' ', '\''));
    }

    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        int size = this.alphabet.size();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterIndexInAlphabet = this.alphabet.indexOf(Character.toLowerCase(letter));
            char encryptedLetter = this.alphabet.get((letterIndexInAlphabet + shift) % size);
            if (Character.isUpperCase(letter)) {
                result.append(Character.toUpperCase(encryptedLetter));
            } else {
                result.append(encryptedLetter);
            }
        }
        return result.toString();
    }

    public String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        int size = this.alphabet.size();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterIndexInAlphabet = this.alphabet.indexOf(Character.toLowerCase(letter));
            int newIndex = ((letterIndexInAlphabet - shift) % size);
            if (newIndex < 0) {
                newIndex += size;
            }
            char decryptedLetter = this.alphabet.get(newIndex);
            if (Character.isUpperCase(letter)) {
                result.append(Character.toUpperCase(decryptedLetter));
            } else {
                result.append(decryptedLetter);
            }
        }
        return result.toString();
    }

    public List<String> decryptByBruteForce(String encryptedText) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < this.alphabet.size() - 1; i++) {
            result.add(this.decrypt(encryptedText, i));
        }
        return result;
    }
}
