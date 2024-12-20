package day_11;

import shared.DataSet;

import java.util.ArrayList;

public class Navigator {
    ArrayList<Stone> stones;

    public Navigator(DataSet file) {
        this.stones = new ArrayList<>();
        String[] split = file.getLines().getFirst().split(" ");
        for(String s : split) {
            stones.add(new Stone(Long.parseLong(s)));
        }
    }

    public void CheckStones() {
        for(int i = 0; i < stones.size(); i++) {
            if(firstRule(stones.get(i))) {
                stones.get(i).setValue(1L);
            } else if (secondRule(stones.get(i))) {
                String value = String.valueOf(stones.get(i).getValue());
                String leftVal = value.substring(0, value.length()/2);
                String rightVal = value.substring(value.length()/2);

                rightVal = rightVal.replaceFirst("^0+", "");
                if (rightVal.isEmpty()) {
                    rightVal = "0";
                }

                stones.get(i).setValue(Long.parseLong(leftVal));
                AddStone(i + 1, new Stone(Long.parseLong(rightVal)));

                i++;
            } else {
                stones.get(i).setValue(stones.get(i).getValue()*2024L);
            }
        }
    }
    
    public boolean secondRule(Stone stone) {
        return String.valueOf(stone.getValue()).length() % 2 == 0; // if number is even
    }
    public boolean firstRule(Stone stone) {
        return stone.getValue() == 0; // if number is 0
    }

    public void AddStone(int pos, Stone stone) {
        stones.add(pos, stone);
    }
}
