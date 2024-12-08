package day_07;

import java.util.ArrayList;

public class Equation {
    long result;
    ArrayList<Long> numbers;

    public Equation(String line) {
        this.result = Long.parseLong(line.split(": ")[0]);

        this.numbers = new ArrayList<>();
        String[] split = line.split(": ")[1].split(" ");
        for(String s : split) {
            numbers.add(Long.parseLong(s));
        }
    }

    public boolean findResult() {
        return solve(0, numbers.getFirst());
    }

    public boolean solve(int index, long currentResult) {
        if(index == numbers.size() - 1) {
            return currentResult == result;
        }

        long nextNum = numbers.get(index + 1);

        if(solve(index + 1, currentResult + nextNum)) {
            return true;
        }

        return solve(index + 1, currentResult * nextNum);
    }
}
