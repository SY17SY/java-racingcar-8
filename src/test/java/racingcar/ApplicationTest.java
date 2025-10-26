package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("기능: 최종 우승자 (단독) 안내 출력하기")
    void 기능_테스트_단독() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("기능: 최종 우승자 (공동) 안내 출력하기")
    void 기능_테스트_공동() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,yeong", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "yeong : -", "최종 우승자 : pobi, yeong");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("경주할 자동차의 이름으로 쉼표(,)가 없는 문자열을 입력 받을 때: \"이름이 쉼표(,)로 구분되지 않았습니다.\"")
    void 예외_테스트_쉼표_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobijavaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름이 쉼표(,)로 구분되지 않았습니다.")
        );
    }

    @Test
    @DisplayName("경주할 자동차의 이름으로 쉼표(,)로 끝나는 문자열을 입력 받을 때: \"경주할 자동차의 이름은 빈 문자열이 될 수 없습니다.\"")
    void 예외_테스트_쉼표로_끝남() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 빈 문자열이 될 수 없습니다.")
        );
    }

    @Test
    @DisplayName("경주할 자동차의 이름으로 연속하는 쉼표(,)가 포함된 문자열을 입력 받을 때: \"경주할 자동차의 이름은 빈 문자열이 될 수 없습니다.\"")
    void 예외_테스트_연속된_쉼표() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 빈 문자열이 될 수 없습니다.")
        );
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 분리한 문자열 중 2개가 동일한 문자열일 때: \"경주할 자동차의 이름은 모두 달라야 합니다.\"")
    void 예외_테스트_동일한_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 모두 달라야 합니다.")
        );
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 분리한 문자열 중에 하나가 5자를 초과할 때: \"자동차 이름은 5자 이하만 가능합니다.\"")
    void 예외_테스트_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 분리한 문자열 중 하나에 영어 대/소문자, 숫자가 아닌 문자가 포함될 때: \"자동차 이름은 영어 대/소문자나 숫자로만 이루어질 수 있습니다.\"")
    void 예외_테스트_기타_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jav@", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 영어 대/소문자나 숫자로만 이루어질 수 있습니다.")
        );
    }

    @Test
    @DisplayName("시도할 횟수로 빈 문자열을 입력 받을 때: \"시도할 횟수를 작성해 주십시오.\"")
    void 예외_테스트_시도_빈_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jav@", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도할 횟수를 작성해 주십시오.")
        );
    }

    @Test
    @DisplayName("시도할 횟수로 음수를 입력 받을 때: \"시도할 횟수는 음수가 될 수 없습니다.\"")
    void 예외_테스트_시도_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도할 횟수는 음수가 될 수 없습니다.")
        );
    }

    @Test
    @DisplayName("시도할 횟수로 숫자가 아닌 문자를 입력 받을 때: \"시도할 횟수에 문자가 포함될 수 없습니다.\"")
    void 예외_테스트_시도_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "a1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도할 횟수에 문자가 포함될 수 없습니다.")
        );
    }

    @Test
    @DisplayName("시도할 횟수로 int 범위를 넘어가는 수를 입력 받을 때: \"시도할 횟수는 int 범위를 초과할 수 없습니다.\"")
    void 예외_테스트_시도_int_범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "3000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도할 횟수는 int 범위를 초과할 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
