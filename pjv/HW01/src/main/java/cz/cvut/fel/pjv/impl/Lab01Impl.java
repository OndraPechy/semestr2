package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Lab01;

import java.util.Scanner;

public class Lab01Impl implements Lab01 {
    @Override
    public void homework() {
        // TODO: Implement the homework here
        System.out.println("Welcome in a calculator! This calculator has 4 functions.\n" +
                "Insert number according to the function you want to choose.\n" +
                "1) Add numbers\n2) Substruct numbers\n3) Multiply numbers\n4) Divide numbers\n" +
                "Please insert a number:  ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.err.println("This is not a number!");
            return;
        }
        int operation = scanner.nextInt();

    }
}
