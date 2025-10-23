package racingcar.config;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationConfig {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingcarService racingcarService() {
        return new RacingcarService(outputView());
    }

    public RacingcarController racingcarController() {
        return new RacingcarController(inputView(), outputView(), racingcarService());
    }
}
