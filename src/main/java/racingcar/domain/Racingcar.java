package racingcar.domain;

import static racingcar.util.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import racingcar.model.*;

public class Racingcar {
    public List<String> parseNames(String inputName) {
        return Arrays.stream(inputName.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public Cars createCars(List<String> names) {
        return new Cars(names.stream().map(Car::new).toList());
    }

    public void race(Cars cars, int count, Consumer<List<CarState>> onEachRound) {
        for (int i = 0; i < count; i++) {
            cars.raceOneRound();
            onEachRound.accept(cars.snapshot());
        }
    }
}
