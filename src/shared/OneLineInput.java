package shared;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OneLineInput {
    ArrayList<Integer> data;

    public OneLineInput(String filename) {
        this.data = ReadData(filename);
    }

    public ArrayList<Integer> ReadData(String filename) {
        ArrayList<Integer> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if(line != null) {
                for(Character c : line.toCharArray()) {
                    data.add(Character.getNumericValue(c));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public ArrayList<Integer> getData() {
        return data;
    }
}
