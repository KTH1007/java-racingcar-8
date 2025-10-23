package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NameExtractor;
import racingcar.domain.RaceCount;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingcarService {
    private final OutputView outputView;

    public RacingcarService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void startRace(String nameInput, String countInput) {
        List<String> names = NameExtractor.extractCarNames(nameInput);

        List<Car> carList = names.stream()
                .map(Car::new)
                .toList();

        Cars cars = new Cars(carList);

        RaceCount raceCount = new RaceCount(countInput);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < raceCount.getCount(); i++) {
            cars.moveAll(randomNumberGenerator);
            outputView.printRaceProgress(cars);
            outputView.printSpace();
        }

        List<Car> winners = cars.findWinners();
        outputView.printWinners(winners);
    }
}
