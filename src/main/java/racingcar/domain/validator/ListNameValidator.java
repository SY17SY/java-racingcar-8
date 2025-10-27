package racingcar.domain.validator;

import static racingcar.util.Constants.*;
import static racingcar.util.Messages.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListNameValidator {
    private static final Pattern NAME_VALID_PATTERN = Pattern.compile(NAME_VALID_REGEX);

    public static void validate(List<String> names) {
        isUnique(names);
        for (String name : names) {
            isOverFive(name);
            isValidCharacters(name);
        }
    }

    private static void isUnique(List<String> names) {
        long distinctCount = names.stream().distinct().count();
        if (distinctCount != names.size()) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_SAME);
        }
    }

    private static void isOverFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_LENGTH);
        }
    }

    private static void isValidCharacters(String name) {
        Matcher matcher = NAME_VALID_PATTERN.matcher(name);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_INVALID);
        }
    }
}
