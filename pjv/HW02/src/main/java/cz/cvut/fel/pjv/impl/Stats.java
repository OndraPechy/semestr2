package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.StatsInterface;

import java.util.Scanner;

public class Stats implements StatsInterface {
    // TODO implement all methods from StatsInterface

//    Scanner scanner = new Scanner(System.in);
    double[] numbers = new double[10];
    int arr_count = 0;


    @Override
    public void addNumber(double number) {
        numbers[arr_count] = number;
        ++arr_count;
        if (arr_count == 10) {
            System.out.println(getFormattedStatistics());
            for (int i = 0; i < arr_count; ++i) {
                numbers[i] = 0.0;
            }
            arr_count = 0;
        }
    }

    @Override
    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < arr_count; ++i) {
            sum += numbers[i];
        }
        return sum / arr_count;
    }

    @Override
    public double getStandardDeviation() {
        double deviation_sum = 0;
        double average = getAverage();
        for (int i = 0; i < arr_count; ++i) {
            deviation_sum += Math.pow(numbers[i] - average, 2);
        }
        double variance = deviation_sum / arr_count;
        return Math.sqrt(variance);

    }

    @Override
    public int getCount() {
        return arr_count;
    }

    @Override
    public String getFormattedStatistics() {
        return String.format("%2d %.3f %.3f", arr_count, getAverage(), getStandardDeviation());
    }
}
