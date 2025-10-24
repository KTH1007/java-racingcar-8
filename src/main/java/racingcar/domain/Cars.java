package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import racingcar.domain.exception.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNotEmpty(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void moveAll(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator));
    }

    public void displayProgress(Consumer<String> displayFunction) {
        cars.forEach(car -> displayFunction.accept(car.createProgressDisplay()));
    }

    public void displayWinners(Consumer<List<String>> displayFunction) {
        List<String> winnerNames = new ArrayList<>();
        Car winner = cars.getFirst();
        for (Car car : cars) {
            if (car.hasHigherPositionThan(winner)) {
                winner = car;
            }
        }

        final Car finalWinner = winner;
        for (Car car : cars) {
            if (car.hasSamePositionAs(finalWinner)) {
                car.addNameToList(winnerNames);
            }
        }

        displayFunction.accept(winnerNames);
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw ErrorMessage.emptyCarList();
        }
    }

}
