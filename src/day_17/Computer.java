package day_17;

import shared.DataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    private int A;
    private int B;
    private int C;
    private final int[] input;
    ArrayList<Integer> output;

    public Computer(DataSet file) {
        this.A = Integer.parseInt(file.getLines().get(0).split(": ")[1]);
        this.B = Integer.parseInt(file.getLines().get(1).split(": ")[1]);
        this.C = Integer.parseInt(file.getLines().get(2).split(": ")[1]);

        String[] program = file.getLines().get(4).split(": ")[1].split(",");
        this.input = new int[program.length];
        for(int i = 0; i < program.length; i++) {
            input[i] = Integer.parseInt(program[i]);
        }
        System.out.println("input: " + Arrays.toString(input));
        this.output = new ArrayList<>();
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int[] getInput() {
        return input;
    }

    public ArrayList<Integer> getOutput() {
        return output;
    }

    public void addResult(int result) {
        output.add(result);
    }
}
