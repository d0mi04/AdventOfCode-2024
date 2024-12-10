package day_08;

import shared.DataSet;

import java.util.ArrayList;
import java.util.HashMap;

public class Scanner {
    Map map;
    ArrayList<Antenna> antennas;

    public Scanner(DataSet file) {
        this.map = new Map(file.getLines());
        this.antennas = new ArrayList<>();
    }

    public int calculateDistance(char frequency) {
        ArrayList<Antenna> filteredAntennas = new ArrayList<>();

        for(Antenna a : antennas) {
            if(a.getFrequency() == frequency) {
                filteredAntennas.add(a);
            }
        }

        int count = 0;
        for(int i = 0; i < filteredAntennas.size(); i++) {
            for(int j = i + 1; j < filteredAntennas.size(); j++) {
                int rowDiff = filteredAntennas.get(i).getPosition()[0] - filteredAntennas.get(j).getPosition()[0];
                int colDiff = filteredAntennas.get(i).getPosition()[1] - filteredAntennas.get(j).getPosition()[1];

                if (map.isOnMap(filteredAntennas.get(j).getPosition()[0] - rowDiff, filteredAntennas.get(j).getPosition()[1] - colDiff)) {
                    if (map.getCharAt(filteredAntennas.get(j).getPosition()[0] - rowDiff, filteredAntennas.get(j).getPosition()[1] - colDiff) == '.') {
                        count++;
                    }
                }

                if (map.isOnMap(filteredAntennas.get(i).getPosition()[0] + rowDiff, filteredAntennas.get(i).getPosition()[1] + colDiff)) {
                    if (map.getCharAt(filteredAntennas.get(i).getPosition()[0] + rowDiff, filteredAntennas.get(i).getPosition()[1] + colDiff) == '.') {
                        count++;
                    }
                }

            }
        }
//        System.out.println("Antinodes: " + count);
        return count;
    }

    public ArrayList<Character> countFrequencies() {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(Antenna a : antennas) {
            frequencyMap.put(a.getFrequency(), frequencyMap.getOrDefault(a.getFrequency(), 0) + 1);
        }

        ArrayList<Character> frequencyArray = new ArrayList<>();
        for(HashMap.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            frequencyArray.add(entry.getKey());
//            System.out.println("Frequency: " + entry.getKey() + ", occurrance: " + entry.getValue());
        }
        return frequencyArray;
    }

    public void scan() {
        for (int row = 0; row < map.getHeight(); row++) {
            for(int col = 0; col < map.getWidth(); col++) {
                if(map.getCharAt(row, col) != '.') {
                    Antenna antenna = new Antenna(map.getCharAt(row, col), row, col);
                    antennas.add(antenna);
                }
            }
        }
    }
}
