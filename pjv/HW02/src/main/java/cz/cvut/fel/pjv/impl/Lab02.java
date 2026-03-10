package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.impl.Stats;

import java.util.Scanner;

public class Lab02 {
    public void main(String[] args) {
        Stats stats = new Stats();
        int line = 0;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String row = scanner.nextLine();
            line++;
            try { // row.trim() deletes invisible spaces from a line, Double.parseDouble parse the
                 // text message to a double value, if there is no double on the line, we get an
                // error which causes catch condition to occur
                double number = Double.parseDouble(row.trim());
                stats.addNumber(number);
            } catch (NumberFormatException e) {
                System.err.println("A number has not been parsed from line " + line);
            }
        }

        System.out.println(stats.getFormattedStatistics());
        System.err.println("End of input detected!\n");
    }
}