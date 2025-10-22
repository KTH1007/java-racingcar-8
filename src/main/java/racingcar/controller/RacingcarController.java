package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printCarNameInputMessage();
        inputView.readCarNames();

        outputView.printRaceCountInputMessage();
        inputView.readRaceCount();
    }
}
