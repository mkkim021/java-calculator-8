package calculator.model;


public class Validator {

    public boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    public void validateParsedInput(String input) {
        if (isEmptyInput(input)) {
            throw new IllegalArgumentException("문자열 형식이 잘못됐습니다");

        }
    }

    public void validateToken(String token) {

        if (token.startsWith("-")) {
            throw new IllegalArgumentException("음수인 수가 있습니다");
        }

        if (!token.matches("\\d+")) {
            throw new IllegalArgumentException("문자가 포함되어 있습니다");

        }
    }
}
