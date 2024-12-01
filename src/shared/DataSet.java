package shared;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataSet {
    ArrayList<String> lines;

    public DataSet(String filename) {
        this.lines = ReadLines(filename);
    }

    public ArrayList<String> ReadLines(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public ArrayList<String> getLines() {
        return this.lines;
    }
}
