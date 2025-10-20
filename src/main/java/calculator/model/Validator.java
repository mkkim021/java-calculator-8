package calculator.model;


import java.util.Set;

public class Validator {

    public boolean isEmptyInput(String targetInput) {
        return targetInput == null || targetInput.isEmpty();
    }

    public void validateTargetInput(String targetInput) {
        if (isEmptyInput(targetInput)) {
            throw new IllegalArgumentException("문자열 내용이 비었습니다");

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

    public void validateDelimiters(Set<Character> delimiter, String targetInput) {

        if (delimiter.contains(targetInput.charAt(0))) {
            throw new IllegalArgumentException("처음에 구분자가 있습니다");
        }

        if (delimiter.contains(targetInput.charAt(targetInput.length() - 1))) {
            throw new IllegalArgumentException("끝에 구분자가 있습니다");
        }

        for (int i = 0; i < targetInput.length() - 1; i++) {
            if (delimiter.contains(targetInput.charAt(i))
                    && delimiter.contains(targetInput.charAt(i + 1))) {
                throw new IllegalArgumentException("구분자가 연속으로 나타났습니다");
            }
        }

    }
}
