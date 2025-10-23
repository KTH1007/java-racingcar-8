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
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public void moveAll(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_LIST);
        }
    }

}
