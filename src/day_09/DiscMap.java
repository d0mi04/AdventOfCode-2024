package day_09;

import java.util.ArrayList;

public class DiscMap {
    private ArrayList<String> fileBlock;
    private int count;

    public DiscMap() {
        this.fileBlock = new ArrayList<>();
        this.count = 0;
    }

    public void addNextBlock(int pos, int num) {
        if(pos % 2 == 0) {
            for(int i = 0; i < num; i++) {
                fileBlock.add(String.valueOf(count));
            }
            count++;
        } else {
            for(int i = 0; i < num; i++) {
                fileBlock.add(".");
            }
        }
    }

    public ArrayList<String> getFileBlock() {
        return fileBlock;
    }
}
