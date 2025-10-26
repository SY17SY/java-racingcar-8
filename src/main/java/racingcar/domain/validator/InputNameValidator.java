package racingcar.domain.validator;

import static racingcar.util.Messages.*;

public class InputNameValidator {
    public static void validate(String inputName) {
        String s = trimOrNull(inputName);
        if (s == null || containsEmpty(s)) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_EMPTY);
        }

        isMissingComma(s);
    }

    private static String trimOrNull(String value) {
        if (value == null) {
            return null;
        }

        String s = value.trim();
        if (s.isEmpty()) {
            return null;
        }
        return s;
    }

    private static boolean containsEmpty(String value) {
        boolean endingComma = value.endsWith(",");
        boolean continuousComma = value.contains(",,");
        return endingComma || continuousComma;
    }

    private static void isMissingComma(String value) {
        if (!value.contains(",")) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_MISSING_COMMA);
        }
    }
}
