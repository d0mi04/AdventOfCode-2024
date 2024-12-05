package day_03;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    String line;
    String program_pattern = "mul\\((\\d+,\\d+)\\)";
    ArrayList<Number> numbers;

    public Program(String line) {
        this.line = line;

        findMatches();
    }

    public void findMatches() {
        Pattern pattern = Pattern.compile(program_pattern);
        Matcher matcher = pattern.matcher(line);

        this.numbers = new ArrayList<>();
        while (matcher.find()) {
            String[] split = matcher.group(1).split(",");
            Number number = new Number(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            numbers.add(number);
        }
    }

    public int sumResult() {
        int part_sum = 0;
        for(Number n : numbers) {
            part_sum+=n.result;
        }

        return part_sum;
    }


}
