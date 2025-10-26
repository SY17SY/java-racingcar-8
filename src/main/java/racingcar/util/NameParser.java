package racingcar.util;

import static racingcar.util.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;

public final class NameParser {
    public static List<String> parseNames(String inputName) {
        return Arrays.stream(inputName.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
