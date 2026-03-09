package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Lab01;

import java.util.Scanner;

public class Lab01Impl implements Lab01 {
    @Override
    public void homework() {
        // -- GET INPUTTED OPERATION --
        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("This is not a number!");
            return;
        }
        int operation = scanner.nextInt();
        if (operation < 1 || operation > 4) {
            System.out.println("Chybna volba!");
            return;
        }
        callFunction(operation, scanner);
        scanner.close();
    }

    private void callFunction(int index, Scanner scanner) {
        switch (index) {
            case 1 -> addNumbers(scanner);
            case 2 -> substructNumbers(scanner);
            case 3 -> multiplyNumbers(scanner);
            case 4 -> divideNumbers(scanner);
            default -> System.out.println("Invalid index!");
        }
    }

    private void addNumbers(Scanner scanner) {
        System.out.println("Zadej scitanec: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num1 = scanner.nextDouble();

        System.out.println("Zadej scitanec: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num2 = scanner.nextDouble();
        System.out.println("Zadej pocet desetinnych mist: ");
        if (!scanner.hasNextInt()) {
            System.out.println("This is not a valid number!");
            return;
        }
        int decimals = scanner.nextInt();
        if (decimals < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }
        // Clever way to change decimals globally
        String part = "%." + decimals + "f";
        String template = part + " + " + part + " = " + part;
        double result = num1 + num2;
        System.out.printf(template + "\n", num1, num2, result);
    }

    private void substructNumbers(Scanner scanner) {
        System.out.println("Zadej mensenec: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num1 = scanner.nextDouble();

        System.out.println("Zadej mensitel: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num2 = scanner.nextDouble();
        System.out.println("Zadej pocet desetinnych mist: ");
        if (!scanner.hasNextInt()) {
            System.out.println("This is not a valid number!");
            return;
        }
        int decimals = scanner.nextInt();
        if (decimals < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }
        String part = "%." + decimals + "f";
        String template = part + " - " + part + " = " + part;
        double result = num1 - num2;
        System.out.printf(template + "\n", num1, num2, result);
    }

    private void multiplyNumbers(Scanner scanner) {
        System.out.println("Zadej cinitel: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num1 = scanner.nextDouble();

        System.out.println("Zadej cinitel: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num2 = scanner.nextDouble();
        System.out.println("Zadej pocet desetinnych mist: ");
        if (!scanner.hasNextInt()) {
            System.out.println("This is not a valid number!");
            return;
        }
        int decimals = scanner.nextInt();
        if (decimals < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }
        String part = "%." + decimals + "f";
        String template = part + " * " + part + " = " + part;
        double result = num1 * num2;
        System.out.printf(template + "\n", num1, num2, result);
    }

    private void divideNumbers(Scanner scanner) {
        System.out.println("Zadej delenec: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num1 = scanner.nextDouble();

        System.out.println("Zadej delitel: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("This is not a number!");
            return;
        }
        double num2 = scanner.nextDouble();
        if (num2 == 0) {
            System.out.println("Pokus o deleni nulou!");
            return;
        }

        System.out.println("Zadej pocet desetinnych mist: ");
        if (!scanner.hasNextInt()) {
            System.out.println("This is not a valid number!");
            return;
        }
        int decimals = scanner.nextInt();
        if (decimals < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }

        String part = "%." + decimals + "f";
        String template = part + " / " + part + " = " + part;
        double result = num1 / num2;
        System.out.printf(template + "\n", num1, num2, result);
    }

}
