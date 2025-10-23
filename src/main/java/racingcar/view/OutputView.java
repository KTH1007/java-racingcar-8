package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class OutputView {
    private final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceProgress(Cars cars) {
        List<String> progressDisplays = cars.getProgressDisplays();
        progressDisplays.forEach(System.out::println);
    }

    public void printSpace() {
        System.out.println();
    }

    public void printWinners(Cars cars) {
        List<String> winnerNames = cars.getWinnerNames();
        String result = String.join(DELIMITER, winnerNames);
        System.out.println(WINNER_MESSAGE + result);
    }
}
