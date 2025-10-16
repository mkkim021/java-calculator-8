package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\n";


    public List<Integer> parsing(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }
        String[] parsed = extractCustomDeli(input);
        String delimiter = parsed[0];
        String parsedInput = parsed[1];

        if (parsedInput == null || parsedInput.isEmpty()) {
            return Collections.emptyList();
        }

        return extractNumbers(delimiter, parsedInput);
    }

    public String[] extractCustomDeli(String input) {

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String normalInput = input.replace("\\n", CUSTOM_DELIMITER_POSTFIX);

            int deliPostIdx = normalInput.indexOf(CUSTOM_DELIMITER_POSTFIX);

            String customDeli = normalInput.substring(2, deliPostIdx);
            String convertInput = normalInput.substring(deliPostIdx + 1);
            String normalDeli = "[" + customDeli + "]";
            return new String[]{normalDeli, convertInput};
        }

        return new String[]{DEFAULT_DELIMITER, input};
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
