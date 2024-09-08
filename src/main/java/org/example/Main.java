package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Cipher cipher = new Cipher();
        Gui gui = new Gui();
        gui.showWelcomeMenu();
        while(true) {
            int shift;
            String message;
            gui.showOptions();
            int chosenOption = gui.getOption();
            switch (chosenOption) {
                case 1:
                    System.out.println("Please provide a message for encryption in resources/input.txt");
                    System.out.println("After filling the file, press Enter to continue.");
                    gui.waitingForEnter();
                    shift = gui.getShiftNumber();
                    message = fileManager.readFile("src/main/resources/input.txt");
                    String encryptedMessage = cipher.encrypt(message, shift);
                    fileManager.writeFile(encryptedMessage, "src/main/resources/output.txt");
                    System.out.println("Here are first 100 characters of encrypted message. " +
                            "Full encrypted message has been stored in resources/output.txt");
                    System.out.println(encryptedMessage.substring(0, 100));
                    System.out.println();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Please provide a message for decryption in resources/input.txt");
                    System.out.println("After filling the file, press Enter to continue.");
                    gui.waitingForEnter();
                    shift = gui.getShiftNumber();
                    message = fileManager.readFile("src/main/resources/input.txt");
                    String decryptedMessage = cipher.decrypt(message, shift);
                    fileManager.writeFile(decryptedMessage, "src/main/resources/output.txt");
                    System.out.println("Here are first 100 characters of decrypted message. " +
                            "Full decrypted message has been stored in resources/output.txt");
                    System.out.println(decryptedMessage.substring(0, 100));
                    System.out.println();

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Please provide a message for brute force decryption in resources/input.txt");
                    System.out.println("After filling the file, press Enter to continue.");
                    gui.waitingForEnter();
                    System.out.println("Program will show all possible decryption (only first 100 characters), " +
                            "please choose correct one:");
                    message = fileManager.readFile("src/main/resources/input.txt");
                    int counter = 1;
                    List<String> allDecryption = cipher.decryptByBruteForce(message);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    for (String eachResult : allDecryption) {
                        System.out.println(counter + ". " + eachResult.substring(0, Math.min(100, message.length())));
                        counter++;
                    }
                    System.out.println();
                    System.out.println("Enter a number: ");
                    int correctOption = gui.getCorrectBruteForce(cipher.getAlphabet().size());
                    String chosenDecryption = allDecryption.get(correctOption - 1);
                    fileManager.writeFile(chosenDecryption, "src/main/resources/output.txt");
                    System.out.println("Here are chosen first 100 characters of decrypted message. " +
                            "Full decrypted message has been stored in resources/output.txt");
                    System.out.println(chosenDecryption.substring(0, 100));
                    System.out.println();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Please provide a message for statistical decryption in resources/input.txt");
                    System.out.println("After filling the file, press Enter to continue.");
                    gui.waitingForEnter();
                    message = fileManager.readFile("src/main/resources/input.txt");
                    String statDecryptedMessage = cipher.decryptByStatistics(message);
                    fileManager.writeFile(statDecryptedMessage, "src/main/resources/output.txt");
                    System.out.println("Your message has been decrypted and stored in resources/output.txt");
                    System.out.println("Here are first 100 characters of statistically decrypted message. " +
                            "Full decrypted message has been stored in resources/output.txt");
                    System.out.println(statDecryptedMessage.substring(0, 100));
                    System.out.println();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Bye!");
                    System.exit(0);
            }
        }
    }
}