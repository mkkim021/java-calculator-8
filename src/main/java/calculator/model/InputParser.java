package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\n";

    private final Validator validator;

    public InputParser() {
        this.validator = new Validator();
    }

    public List<Integer> parsing(String input) {

        if (validator.isEmptyInput(input)) {
            return Collections.emptyList();
        }

        String[] parsed = extractCustomDeli(input);
        String delimiter = parsed[0];
        String parsedInput = parsed[1];

        validator.validateParsedInput(parsedInput);

        return extractNumbers(delimiter, parsedInput);
    }

    public String[] extractCustomDeli(String input) {

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {

            validator.validateCustomDeliPostfix(input);

            String normalInput = input.replace("\\n", CUSTOM_DELIMITER_POSTFIX);

            int deliPostIdx = normalInput.indexOf(CUSTOM_DELIMITER_POSTFIX);

            String customDeli = normalInput.substring(2, deliPostIdx);

            validator.validateCustomDelimiter(customDeli);

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
            validator.validateToken(token);
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }
}
