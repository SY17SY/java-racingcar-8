package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.domain.Racingcar;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        Racingcar racingcar = new Racingcar();

        RacingcarController controller = new RacingcarController(consoleInput, consoleOutput, racingcar);

        controller.runController();
    }
}
