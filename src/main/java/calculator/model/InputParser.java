package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\n";

    private final Validator validator;

    private Set<Character> delimiters = new HashSet<>();

    public InputParser(Validator validator) {
        this.validator = validator;
        this.delimiters.add(',');
        this.delimiters.add(':');
    }

    public List<Integer> parsing(String input) {
        if (validator.isEmptyInput(input)) {
            return Collections.emptyList();
        }

        String targetInput = extractCustomDeli(input);

        validator.validateTargetInput(targetInput);

        return extractNumbers(targetInput);
    }

    public String extractCustomDeli(String input) {

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {

            validator.validateCustomDeliPostfix(input);

            String normalInput = input.replace("\\n", CUSTOM_DELIMITER_POSTFIX);

            int deliPostIdx = normalInput.indexOf(CUSTOM_DELIMITER_POSTFIX);

            String customDeli = normalInput.substring(2, deliPostIdx);

            validator.validateCustomDelimiter(customDeli);

            delimiters.add(customDeli.charAt(0));

            return normalInput.substring(deliPostIdx + 1);
        }

        return input;
    }


    public List<Integer> extractNumbers(String targetInput) {

        validator.validateDelimiters(delimiters, targetInput);

        List<Integer> numbers = new ArrayList<>();
        StringBuilder token = new StringBuilder();

        for (char c : targetInput.toCharArray()) {
            if (delimiters.contains(c)) {
                validator.validateToken(token.toString());
                numbers.add(Integer.parseInt(token.toString()));
                token = new StringBuilder();
            } else {
                token.append(c);
            }
        }
        if (!token.isEmpty()) {
            numbers.add(Integer.parseInt(token.toString()));
        }

        return numbers;
    }
}
