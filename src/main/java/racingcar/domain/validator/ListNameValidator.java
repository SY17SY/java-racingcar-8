package racingcar.domain.validator;

import static racingcar.util.Messages.*;

import java.util.List;

public class ListNameValidator {
    public static void validate(List<String> names) {
        isUnique(names);
        for (String name : names) {
            isOverFive(name);
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
}
