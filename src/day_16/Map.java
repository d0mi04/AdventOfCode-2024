package day_16;

import shared.DataSet;

import java.util.ArrayList;

public class Map {
    private ArrayList<String> map;

    public Map(DataSet file){
        CreateMap(file);
    }

    public void CreateMap(DataSet file) {
        this.map = new ArrayList<>();
        map.addAll(file.getLines());
    }

    public int[] findLetter(char c) {
        for(int row = 0; row < map.size(); row++) {
            for(int col = 0; col < map.getFirst().length(); col++) {
                if(getCharAt(row, col) == c) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public char getCharAt(int row, int col) {
        return map.get(row).charAt(col);
    }

    public void printMap(){
        for(String s : map) {
            System.out.println(s);
        }
    }

    public ArrayList<String> getMap() {
        return map;
    }
}
