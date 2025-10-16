package calculator.model;

import java.util.List;

public class Calculator {

    private final InputParser parser;

    public Calculator() {
        this.parser = new InputParser();
    }

    public int calculate(String input) {
        List<Integer> numbers = parser.parsing(input);

        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
