package org.example;

import java.util.Scanner;

public class Gui {
    public void showWelcomeMenu() {
        String asciiArt = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣿⣿⢿⡶⠆⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⡿⠻⠋⣠⠀⢀⣶⠇⢠⣾⡿⠁⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢀⣼⠟⠋⠻⢁⣴⠀⣾⣿⠀⠾⠟⠀⠈⣉⣠⣦⡤⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠸⠃⣠⡆⠀⣿⡟⠀⠛⠃⠀⠀⣶⣶⣦⣄⠉⢁⡄⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣰⡀⢰⣿⠇⠀⢉⣀⣀⠛⠿⠿⠦⠀⢀⣠⣤⣴⣾⡇⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⠃⠀⠠⣴⣦⡈⠙⠛⠓⠀⢰⣶⣶⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀
⠀⠀⢀⣤⠦⡀⠰⢷⣦⠈⠉⠉⠀⣰⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀
⠀⠀⠈⠁⠀⠘⣶⣤⣄⣀⣨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠃⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣯⡈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣷⣤⣈⡉⠛⠛⠛⠛⠻⠟⠛⠛⠛⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠙⠻⠿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        """;
        System.out.println(asciiArt);
        System.out.println("Welcome in Caesar cipher.");
    }

    public void showOptions() {
        System.out.println("Please choose option by entering a number:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Decrypt by brute force");
        System.out.println("4. Decrypt by statistics");
        System.out.println("5. Exit");
    }

    public int getOption() {
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option > 0 && option < 6) {
                    break;
                }
                System.out.println("No such option, try again.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return option;
    }

    public int getShiftNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide shift number:");
        int shift;
        while(true) {
            if (scanner.hasNextInt()) {
                shift = scanner.nextInt();
                if (shift > 0) {
                    break;
                }
                System.out.println("Shift should be a positive number.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return shift;
    }

    public void waitingForEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public int getCorrectBruteForce(int maxNumber) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0 && number < maxNumber + 1) {
                    break;
                }
                System.out.println("No such number.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return number;
    }

}
