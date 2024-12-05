package day_03;

public class Number {
    int x;
    int y;
    int result;

    public Number(int x, int y) {
        this.x = x;
        this.y = y;
        this.result = countResult();
    }

    public int countResult() {
        return this.x * this.y;
    }
}
