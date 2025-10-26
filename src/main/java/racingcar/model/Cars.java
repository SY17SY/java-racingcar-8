package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars fromNames(List<String> names) {
        return new Cars(names.stream().map(Car::withRandomMoveStrategy).toList());
    }

    public void raceOneRound() {
        cars.forEach(Car::moveOrStay);
    }

    public List<CarState> snapshot() {
        return cars.stream().map(Car::toState).toList();
    }

    public List<String> findWinnerNames() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
