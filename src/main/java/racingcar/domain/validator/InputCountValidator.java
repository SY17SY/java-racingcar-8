package racingcar.domain.validator;

import static racingcar.util.Messages.*;

public class InputCountValidator {
    public static void validate(String input) {
        String s = trimOrNull(input);
        if (s == null) {
            throw new IllegalArgumentException(ERROR_MSG_COUNT_EMPTY);
        }
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
}
