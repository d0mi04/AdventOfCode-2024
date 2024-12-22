package day_13;

import shared.DataSet;

public class Day13 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_13/input-13.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part2(DataSet file) {
        Controller controller = new Controller(file);

        long total = 0;
        for(Machine m : controller.machines) {
            m.CorrectPrize();
//            System.out.println(m.getPrize()[0] + ", " + m.getPrize()[1]);
            if(m.isSolution()) {
                total += m.FindSolution();
            }
        }
        System.out.println(total);
    }

    public static void Part1(DataSet file) {
        Controller controller = new Controller(file);

        long total = 0;
        for(Machine m : controller.machines) {
//            System.out.println(m.isSolution());
            if(m.isSolution()) {
                total += m.FindSolution();
            }
        }
        System.out.println(total);
    }
}
