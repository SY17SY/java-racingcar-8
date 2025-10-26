package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_FORWARD_NUM = 4;
    private static final int RANDOM_NUM_START = 0;
    private static final int RANDOM_NUM_END = 9;

    @Override
    public boolean movable() {
        int n = Randoms.pickNumberInRange(RANDOM_NUM_START, RANDOM_NUM_END);
        return n >= MOVE_FORWARD_NUM;
    }
}
