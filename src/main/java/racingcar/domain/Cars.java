package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.exception.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNotEmpty(cars);
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> findWinners() {
        Car winner = cars.getFirst();
        for (Car car : cars) {
            if (car.hasHigherPositionThan(winner)) {
                winner = car;
            }
        }

        final Car finalWinner = winner;

        return cars.stream()
                .filter(car -> car.hasSamePositionAs(finalWinner))
                .toList();
    }

    public void moveAll(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator));
    }

    public List<String> getProgressDisplays() {
        return cars.stream()
                .map(Car::createProgressDisplay)
                .toList();
    }

    public List<String> getWinnerNames() {
        return findWinners().stream()
                .map(Car::createNameDisplay)
                .toList();
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_LIST);
        }
    }

}
