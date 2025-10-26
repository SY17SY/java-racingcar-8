package racingcar.controller;

import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class RacingcarController {
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;

    RacingcarController(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public void runController() {
        consoleOutput.printPromptName();
        String inputName = consoleInput.inputName();

        consoleOutput.printPromptCount();
        int count = consoleInput.inputCount();

        consoleOutput.printPromptExecution();
        consoleOutput.printExecutionResult();
    }
}
