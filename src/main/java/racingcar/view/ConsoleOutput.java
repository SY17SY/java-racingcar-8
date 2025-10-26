package racingcar.view;

import static racingcar.util.Constants.*;
import static racingcar.util.Messages.*;

import java.util.List;
import racingcar.model.CarState;

public class ConsoleOutput {
    public void printPromptName() {
        System.out.println(PROMPT_MSG_NAME);
    }

    public void printPromptCount() {
        System.out.println(PROMPT_MSG_COUNT);
    }

    public void printPromptExecution() {
        System.out.println();
        System.out.println(PROMPT_MSG_EXECUTION);
    }

    public void printExecutionResult(List<CarState> states) {
        for (CarState s : states) {
            String bar = PROGRESS.repeat(s.position());
            System.out.println(s.name() + " : " + bar);
        }
        System.out.println();
    }

    public void printWinner(List<String> names) {
        String joined = String.join(", ", names);
        System.out.println(PROMPT_MSG_WINNER_ANNOUNCEMENT + joined);
    }
}
