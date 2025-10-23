package racingcar.controller;

import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingcarService racingcarService;

    public RacingcarController(InputView inputView, OutputView outputView, RacingcarService racingcarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingcarService = racingcarService;
    }

    public void run() {
        outputView.printCarNameInputMessage();
        String nameInput = inputView.readCarNames();

        outputView.printRaceCountInputMessage();
        String countInput = inputView.readRaceCount();

        racingcarService.startRace(nameInput, countInput);
    }
}
