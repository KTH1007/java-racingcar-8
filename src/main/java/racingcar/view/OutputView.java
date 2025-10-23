package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String POSITION_SYMBOL = "-";

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceProgress(Cars cars) {
        cars.getCars().forEach(car -> {
            String progress = POSITION_SYMBOL.repeat(car.getPosition());
            System.out.println(car.getName() + " : " + progress);
        });
    }

    public void printSpace() {
        System.out.println();
    }

    public void printWinners(List<Car> winner) {
        String winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(WINNER_MESSAGE + " " + winnerNames);
    }
}
