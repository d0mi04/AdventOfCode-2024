package day_13;

import shared.DataSet;

import java.util.ArrayList;

public class Controller {
    ArrayList<Machine> machines;

    public Controller(DataSet file) {
        this.machines = CreateMachines(file);
    }

    public ArrayList<Machine> CreateMachines(DataSet file) {
        this.machines = new ArrayList<>();
        ArrayList<String> section = new ArrayList<>();
        for(String s : file.getLines()) {
            if (s.isBlank()) {
                if (!section.isEmpty()) {
                    machines.add(new Machine(section));
                    section.clear();
                }
            } else {
                section.add(s);
            }
        }

            if(!section.isEmpty()) {
                machines.add(new Machine(section));
            }
        return machines;
    }
}
