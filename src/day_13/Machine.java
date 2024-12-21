package day_13;

import java.util.ArrayList;

public class Machine {
    private final int[] A;
    private final int[] B;
    private final int[] prize;

    public Machine(ArrayList<String> section) {
        this.A = SetButton(section.get(0));
        this.B = SetButton(section.get(1));
        this.prize = SetPrize(section.get(2));
    }

    public int FindSolution() {
        int count = 0;
        int detA = getA()[0] * getB()[1] - getA()[1] * getB()[0];
        if(detA == 0) {
//            System.out.println("detA = 0");
            return 0;
        }

        int detAa = getPrize()[0] * getB()[1] - getB()[0] * getPrize()[1];
        int detAb = getA()[0] * getPrize()[1] - getA()[1] * getPrize()[0];

        int a = detAa / detA;
        int b = detAb / detA;

        if(detAa % detA == 0 && detAb % detA == 0) {
//            System.out.println("Solution: " + a + ", " + b);
            return count += a * 3 + b;
        } else {
//            System.out.println("is not integer");
            return 0;
        }
    }

    public boolean isSolution() {
        int gX = GCD(getA()[0], getB()[0]);
        int gY = GCD(getA()[1], getB()[1]);
        return getPrize()[0] % gX == 0 && getPrize()[1] % gY == 0;
    }

    public int GCD(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a; // GCD
    }

    public int[] SetButton(String line) {
        String[] split = line.split("X\\+|, Y\\+");
        int x = Integer.parseInt(split[1].trim());
        int y = Integer.parseInt(split[2].trim());
        return new int[]{x, y};
    }

    public int[] SetPrize(String line) {
        String[] split = line.split("X=|, Y=");
        int x = Integer.parseInt(split[1].trim());
        int y = Integer.parseInt(split[2].trim());
        return new int[]{x, y};
    }

    public int[] getA() {
        return A;
    }

    public int[] getB() {
        return B;
    }

    public int[] getPrize() {
        return prize;
    }
}
