package day_19;

import shared.DataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Onsen {
    private final HashSet<String> towels;
    private final ArrayList<String> designs;

    public Onsen(DataSet file) {
        this.towels = new HashSet<>();
        towels.addAll(Arrays.asList(file.getLines().getFirst().split(", ")));

        this.designs = new ArrayList<>();
        for(int i = 2; i < file.getLines().size(); i++) {
            this.designs.add(file.getLines().get(i));
        }
    }

    public int countDesigns() {
        int count = 0;
        for(String design : designs) {
            if(canMakePattern(design)){
                count++;
            }
        }
        return count;
    }

    public boolean canMakePattern(String design) {
        int n = design.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < i; j++){
                String subDesign = design.substring(j, i);
                if(dp[j] && towels.contains(subDesign)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public ArrayList<String> getDesigns() {
        return designs;
    }

    public HashSet<String> getTowels() {
        return towels;
    }
}
