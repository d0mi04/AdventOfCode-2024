package day_05;

import shared.DataSet;

import java.util.ArrayList;

public class Day05 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_05/input-05.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        ArrayList<String> rulesList = new ArrayList<>();
        ArrayList<String> updatesList = new ArrayList<>();
        boolean change = false;

        for(String line : file.getLines()) {
            if(line.isEmpty()) {
                change = true;
                continue;
            }
            if(!change) {
                rulesList.add(line);
            } else {
                updatesList.add(line);
            }
        }

        UpdateLogic pageRules = new UpdateLogic(rulesList, updatesList);
        pageRules.CheckAllOrder();
        pageRules.findMiddleNumber();
//        pageRules.printOrder();
//        pageRules.printRightOrder();
    }
}
