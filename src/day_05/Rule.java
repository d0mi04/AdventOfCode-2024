package day_05;

import java.util.ArrayList;

public class Rule {
    int pageNumber;
    ArrayList<Integer> previousNumbers;
    ArrayList<Integer> nextNumbers;

    public Rule(int pageNumber) {
        this.pageNumber = pageNumber;
        this.previousNumbers = new ArrayList<>();
        this.nextNumbers = new ArrayList<>();
    }

    public void AddPrevious(int previous) {
        previousNumbers.add(previous);
    }

    public void AddNext(int next) {
        nextNumbers.add(next);
    }
}
