package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    private static final String DEFAULT_DELIMITER = "[,:]";


    public List<Integer> parsing(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        return extractNumbers(DEFAULT_DELIMITER, input);
    }


    public List<Integer> extractNumbers(String delimiter, String input) {
        String[] tokens = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }
}
