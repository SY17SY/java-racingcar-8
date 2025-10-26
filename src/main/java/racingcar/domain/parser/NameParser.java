package racingcar.domain.parser;

import static racingcar.util.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.validator.ListNameValidator;

public final class NameParser {
    public static List<String> parseNames(String inputName) {
        List<String> names = Arrays.stream(inputName.split(DELIMITER))
                .map(String::trim)
                .toList();
        ListNameValidator.validate(names);
        return names;
    }
}
