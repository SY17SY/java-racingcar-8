package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {
    public String inputName() {
        String input = Console.readLine();
        return input;
    }

    public int inputCount() {
        String input = Console.readLine();
        int count = Integer.parseInt(input);
        return count;
    }
}
