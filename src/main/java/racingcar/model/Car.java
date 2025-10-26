package racingcar.model;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Car {
    private final String name;
    private final MoveStrategy strategy;
    private int position;

    public Car(String name, MoveStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.position = 0;
    }

    public static Car withRandomMoveStrategy(String name) {
        return new Car(name, new RandomMoveStrategy());
    }

    public void moveOrStay() {
        if (strategy.movable()) {
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
