package racingcar.domain.validator;

import static racingcar.util.Messages.*;

public class InputCountValidator {
    public static void validate(String input) {
        String s = trimOrNull(input);
        if (s == null) {
            throw new IllegalArgumentException(ERROR_MSG_COUNT_EMPTY);
        }

        long longValue = parseLongOrIAE(s);
        isNegative(longValue);
        isOverInt(longValue);
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

    private static long parseLongOrIAE(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG_COUNT_INVALID);
        }
    }

    private static void isNegative(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_MSG_COUNT_NEGATIVE);
        }
    }

    private static void isOverInt(Long value) {
        if (value > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MSG_COUNT_INT_OVER);
        }
    }
}
