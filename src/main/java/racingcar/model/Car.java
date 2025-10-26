package racingcar.model;

import static racingcar.util.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveOrStay() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUM_START, RANDOM_NUM_END);
        if (randomNumber >= MOVE_FORWARD_NUM) {
            position++;
        }
    }

    public CarState toState() {
        return new CarState(name, position);
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }
}
