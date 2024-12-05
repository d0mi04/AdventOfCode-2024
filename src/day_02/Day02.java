package day_02;

import shared.DataSet;

import java.util.ArrayList;

public class Day02 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_02/input-02.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        ArrayList<Report> reports = new ArrayList<>();
        for(String line : file.getLines()) {
            Report report = new Report(line);
            reports.add(report);
        }

        int sum = 0;
        for(Report rep : reports) {
            if(rep.isSafe) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
