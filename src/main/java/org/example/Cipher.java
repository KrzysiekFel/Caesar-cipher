package org.example;

import java.util.*;

public class Cipher {
    private final List<Character> alphabet;
    private final Set<String> commonWords = new HashSet<>(Arrays.asList("the", "of", "and", "a", "to", "in", "is",
            "you", "that", "it", "he", "was", "for", "on", "are", "as", "with", "his", "they", "I", "at", "be",
            "this", "have", "from", "or", "one", "had", "by", "word", "but", "not", "what", "all", "were", "we",
            "when", "your", "can", "said", "there", "use", "an", "each", "which", "she" ,"do", "how", "their", "if",
            "will", "up", "other", "about", "out", "many", "then", "them", "these", "so", "some", "her", "would",
            "make", "like", "him", "into", "time", "has", "look", "two", "more", "write", "go", "see", "number", "no",
            "way", "could", "people", "my", "than", "first", "water", "been", "call", "who", "oil", "its", "now",
            "find", "long", "down", "day", "did", "get", "come", "made", "may", "part"));

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

    public String decryptByStatistics(String encryptedText) {
        int maxCommonWordsCount = 0;
        String bestDecryptedText = "";
        for (String decryptedText : this.decryptByBruteForce(encryptedText)) {
            String[] words = decryptedText.replaceAll("\\p{Punct}", " ").split("\\s+");
            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                uniqueWords.add(word.toLowerCase());
            }
            uniqueWords.retainAll(this.commonWords);
            int commonWordsCount = uniqueWords.size();
            System.out.println(commonWordsCount);
            if (commonWordsCount > maxCommonWordsCount) {
                maxCommonWordsCount = commonWordsCount;
                bestDecryptedText = decryptedText;
            }
        }
        return bestDecryptedText;
    }
}
