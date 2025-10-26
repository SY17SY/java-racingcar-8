package racingcar.view;

import static racingcar.util.Messages.*;

import java.util.List;

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

    public void printExecutionResult() {
        System.out.println();
        // 구현 예정
    }

    public void printWinner(List<String> names) {
        String joined = String.join(", ", names);
        System.out.println(PROMPT_MSG_WINNER_ANNOUNCEMENT + joined);
    }
}
