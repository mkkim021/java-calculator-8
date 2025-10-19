package calculator.model;


public class Validator {

    public boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    public void validateParsedInput(String input) {
        if (isEmptyInput(input)) {
            throw new IllegalArgumentException("문자열 내용이 잘못됐습니다");

        }
    }

    public void validateToken(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException("구분자가 연속 혹은 앞에 구분자가 있습니다");
        }
        if (token.startsWith("-")) {
            throw new IllegalArgumentException("음수인 수가 있습니다");
        }

        if (!token.matches("\\d+")) {
            throw new IllegalArgumentException("문자가 포함되어 있습니다");

        }
    }

    public void validateCustomDelimiter(String customDeli) {
        if (customDeli.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비었습니다");
        }
        if (customDeli.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 가능합니다");
        }
        if (customDeli.matches("\\d")) {
            throw new IllegalArgumentException("숫자는 커스텀 구분자가 불가능합니다");
        }


    }

    public void validateCustomDeliPostfix(String input) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못됐습니다");
        }


    }

    public void validateEndDelimiter() {
        throw new IllegalArgumentException("끝에 구분자가 있습니다");
    }
}
