package racingcar.domain.validator;

import static racingcar.domain.validator.Validator.trimOrNull;
import static racingcar.util.Constants.*;
import static racingcar.util.Messages.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNameValidator {
    private static final Pattern CONTINUOUS_COMMA_PATTERN = Pattern.compile(CONTINUOUS_COMMA_REGEX);

    public static void validate(String inputName) {
        String s = trimOrNull(inputName);
        if (s == null || containsEmpty(s)) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_EMPTY);
        }

        isMissingComma(s);
    }

    private static boolean containsEmpty(String value) {
        Matcher matcher = CONTINUOUS_COMMA_PATTERN.matcher(value);

        boolean startingComma = value.startsWith(DELIMITER);
        boolean endingComma = value.endsWith(DELIMITER);
        boolean continuousComma = matcher.find();
        return startingComma || endingComma || continuousComma;
    }

    private static void isMissingComma(String value) {
        if (!value.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_MISSING_COMMA);
        }
    }
}
