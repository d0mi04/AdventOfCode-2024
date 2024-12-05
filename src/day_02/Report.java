package day_02;

import java.util.ArrayList;

public class Report {
    ArrayList<Integer> reportLine;
    boolean isSafe;

    public Report(String line) {
        reportLine = new ArrayList<>();
        String[] split = line.split(" ");
        for(String s : split) {
            reportLine.add(Integer.parseInt(s));
        }

        isRecordSafe();
    }

    public void isRecordSafe() {
        this.isSafe = checkOrder() && checkDifference();
    }

    public boolean checkDifference() {
        for(int i = 0; i < reportLine.size() - 1; i++) {
            if(Math.abs(reportLine.get(i + 1) - reportLine.get(i)) < 1
                || Math.abs(reportLine.get(i + 1) - reportLine.get(i)) > 3) {
                return false;
            }
        }
        return true;
    }

    public boolean checkOrder() {
        for(int i = 0; i < reportLine.size() - 2; i++) {
            if(reportLine.get(i) < reportLine.get(i+1)) {
                if(reportLine.get(i+1) > reportLine.get(i+2)) {
//                    this.isSafe = false;
                    return false;
                }
            } else if (reportLine.get(i) > reportLine.get(i+1)) {
                if(reportLine.get(i+1) < reportLine.get(i+2)) {
//                    this.isSafe = false;
                    return false;
                }
            }
        }
        return true;
    }
}
