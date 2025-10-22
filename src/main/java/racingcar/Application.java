package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.ApplicationConfig;
import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        try {
            ApplicationConfig config = new ApplicationConfig();
            RacingcarController controller = config.racingcarController();
            controller.run();
        } finally {
            Console.close();
        }
    }
}
