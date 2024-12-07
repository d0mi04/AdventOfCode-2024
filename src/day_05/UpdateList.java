package day_05;

import java.util.ArrayList;

public class UpdateList {
    ArrayList<Integer> updates;
    boolean isOrderRight;

    public UpdateList(String line) {
        this.updates = new ArrayList<>();
        this.isOrderRight = false;
        CreateList(line);
    }

    public void CreateList(String line) {
        String[] split = line.split(",");
        for(String s : split) {
            updates.add(Integer.parseInt(s));
        }
    }
}
