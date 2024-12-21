package day_13;

import shared.DataSet;

public class Day13 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_13/input-13.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Controller controller = new Controller(file);

        int total = 0;
        for(Machine m : controller.machines) {
//            System.out.println(m.isSolution());
            if(m.isSolution()) {
                total += m.FindSolution();
            }
        }
        System.out.println(total);


    }
}
