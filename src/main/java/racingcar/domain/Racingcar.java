package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;
import racingcar.model.*;

public class Racingcar {
    public List<String> race(Cars cars, int count, Consumer<List<CarState>> onEachRound) {
        for (int i = 0; i < count; i++) {
            cars.raceOneRound();
            onEachRound.accept(cars.snapshot());
        }
        return cars.findWinnerNames();
    }
}
