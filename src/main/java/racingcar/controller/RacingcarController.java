package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.parser.NameParser;
import racingcar.domain.Racingcar;
import racingcar.model.Cars;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class RacingcarController {
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final Racingcar racingcar;

    public RacingcarController(ConsoleInput consoleInput, ConsoleOutput consoleOutput, Racingcar racingcar) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.racingcar = racingcar;
    }

    public void runController() {
        consoleOutput.printPromptName();
        String inputName = consoleInput.inputName();

        List<String> names = NameParser.parseNames(inputName);
        Cars cars = Cars.fromNames(names);

        consoleOutput.printPromptCount();
        int count = consoleInput.inputCount();

        consoleOutput.printPromptExecution();
        List<String> winners = racingcar.race(cars, count, consoleOutput::printExecutionResult);

        consoleOutput.printWinner(winners);
        Console.close();
    }
}
