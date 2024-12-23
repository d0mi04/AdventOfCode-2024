package day_16;

public class Reindeer {
    private int[] pos;
    private int[] dir;

    public Reindeer(int col, int row) {
        this.pos = new int[]{col, row};
        this.dir = new int[]{1, 0}; // initial - facing east
    }

    public void printReindeer(){
        System.out.println("X: " + getPos()[0] + ", Y: " + getPos()[1] + ", dir: " + getDir()[0] + ", " + getDir()[1]);
    }

    public void setDir(int[] dir) {
        this.dir = dir;
    }

    public int[] getDir(){
        return dir;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int[] getPos() {
        return pos;
    }
}
