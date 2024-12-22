package day_13;

import java.util.ArrayList;

public class Machine {
    private final long[] A;
    private final long[] B;
    private final long[] prize;

    public Machine(ArrayList<String> section) {
        this.A = SetButton(section.get(0));
        this.B = SetButton(section.get(1));
        this.prize = SetPrize(section.get(2));
    }

    public void CorrectPrize() {
        long additionalDigits = 10000000000L;

        this.prize[0] += additionalDigits * 1000L;
        this.prize[1] += additionalDigits * 1000L;
    }

    public long FindSolution() {
        long count = 0;
        long detA = getA()[0] * getB()[1] - getA()[1] * getB()[0];
        if(detA == 0) {
//            System.out.println("detA = 0");
            return 0;
        }

        long detAa = getPrize()[0] * getB()[1] - getB()[0] * getPrize()[1];
        long detAb = getA()[0] * getPrize()[1] - getA()[1] * getPrize()[0];

        long a = detAa / detA;
        long b = detAb / detA;

        if(detAa % detA == 0 && detAb % detA == 0) {
//            System.out.println("Solution: " + a + ", " + b);
            return count += a * 3 + b;
        } else {
//            System.out.println("is not integer");
            return 0;
        }
    }

    public boolean isSolution() {
        long gX = GCD(getA()[0], getB()[0]);
        long gY = GCD(getA()[1], getB()[1]);
        return getPrize()[0] % gX == 0 && getPrize()[1] % gY == 0;
    }

    public long GCD(long a, long b) {
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a; // GCD
    }

    public long[] SetButton(String line) {
        String[] split = line.split("X\\+|, Y\\+");
        long x = Long.parseLong(split[1].trim());
        long y = Long.parseLong(split[2].trim());
        return new long[]{x, y};
    }

    public long[] SetPrize(String line) {
        String[] split = line.split("X=|, Y=");
        long x = Long.parseLong(split[1].trim());
        long y = Long.parseLong(split[2].trim());
        return new long[]{x, y};
    }

    public long[] getA() {
        return A;
    }

    public long[] getB() {
        return B;
    }

    public long[] getPrize() {
        return prize;
    }
}
