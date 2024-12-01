package day_01;

import shared.DataSet;

import java.util.ArrayList;
import java.util.Collections;

public class Lists {
    ArrayList<Integer> list1;
    ArrayList<Integer> list2;

    public Lists(DataSet file) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        for(String line : file.getLines()) {
            int num1 = Integer.parseInt(line.split("\\s*")[0]);
            int num2 = Integer.parseInt(line.split("\\s*")[1]);

            list1.add(num1);
            list2.add(num2);
        }
    }

    public void SortLists() {
        Collections.sort(list1);
        Collections.sort(list2);
    }

    public int countDistance() {
        int sum = 0;
        for(int i = 0; i < list1.size(); i++) {
            int dist = Math.abs(list2.get(i) - list1.get(i));
            sum+=dist;
        }

        return sum;
    }

    public int countOccurance() {
        int sum = 0;
        for(Integer key : list1) {
            int count = 0;
            for(Integer value : list2) {
                if(key.equals(value)) {
                    count++;
                }
            }
            sum+=key*count;
        }

        return sum;
    }
}
