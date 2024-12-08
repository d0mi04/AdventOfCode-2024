package day_08;

public class Antenna {
    char frequency;
    int[] position;

    public Antenna (char frequency, int row, int col) {
        this.frequency = frequency;
        this.position = new int[]{row, col};
    }

    public char getFrequency() {
        return frequency;
    }

    public int[] getPosition() {
        return position;
    }

    public void printAntenna() {
        System.out.println("ferquency: " + frequency);
        System.out.println("position: " + position[0] + ", " + position[1]);
    }

}
