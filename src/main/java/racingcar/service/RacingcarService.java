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

        int round = 0;
        while (raceCount.hasMoreRound(round++)) {
            cars.moveAll(randomNumberGenerator);
            outputView.printRaceProgress(cars);
            outputView.printSpace();
        }

        outputView.printWinners(cars);
    }
}
