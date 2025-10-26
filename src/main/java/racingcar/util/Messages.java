package racingcar.util;

public class Messages {
    public static String PROMPT_MSG_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String PROMPT_MSG_COUNT = "시도할 횟수는 몇 회인가요?";
    public static String PROMPT_MSG_EXECUTION = "실행 결과";
    public static String PROMPT_MSG_WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public static String ERROR_MSG_NAME_MISSING_COMMA = "자동차 이름이 쉼표(,)로 구분되지 않았습니다.";
    public static String ERROR_MSG_NAME_EMPTY = "자동차 이름은 빈 문자열이 될 수 없습니다.";
    public static String ERROR_MSG_NAME_SAME = "자동차 이름은 모두 달라야 합니다.";
    public static String ERROR_MSG_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    public static String ERROR_MSG_NAME_INVALID = "자동차 이름은 영어 대/소문자나 숫자로만 이루어질 수 있습니다.";

    public static String ERROR_MSG_COUNT_EMPTY = "시도할 횟수를 작성해 주십시오.";
    public static String ERROR_MSG_COUNT_NEGATIVE = "시도할 횟수는 음수가 될 수 없습니다.";
    public static String ERROR_MSG_COUNT_INVALID = "시도할 횟수에 문자가 포함될 수 없습니다.";
    public static String ERROR_MSG_COUNT_INT_OVER = "시도할 횟수는 int 범위를 초과할 수 없습니다.";
}
