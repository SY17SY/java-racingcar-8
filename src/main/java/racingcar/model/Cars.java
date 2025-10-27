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
        List<CarState> states = snapshot();
        int max = states.stream()
                .mapToInt(CarState::position)
                .max()
                .orElse(0);
        return states.stream()
                .filter(s -> s.position() == max)
                .map(CarState::name)
                .collect(Collectors.toList());
    }
}
