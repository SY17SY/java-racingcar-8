package racingcar.domain.validator;

public class Validator {
    static String trimOrNull(String value) {
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
