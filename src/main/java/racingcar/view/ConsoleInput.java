package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.validator.InputNameValidator;

public class ConsoleInput {
    public String inputName() {
        String input = Console.readLine();
        InputNameValidator.validate(input);
        return input;
    }

    public int inputCount() {
        String input = Console.readLine();
        int count = Integer.parseInt(input);
        return count;
    }
}
