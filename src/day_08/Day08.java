package day_08;

import shared.DataSet;

public class Day08 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_08/test-08.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Scanner scanner = new Scanner(file);
        scanner.scan();

//        // wypisanie szczegółów anten:
//        for(Antenna antenna : scanner.antennas) {
//            if(antenna.getFrequency() == '0') {
//                antenna.printAntenna();
//            }
//        }

        int count = 0;
        for(Character frequency : scanner.countFrequencies()) {
            count+=scanner.calculateDistance(frequency);
        }

        System.out.println(count);
//        scanner.countFrequencies();
    }
}
