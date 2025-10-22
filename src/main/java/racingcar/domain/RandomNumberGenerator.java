package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int MOVE_THRESHOLD = 4;

    public boolean shouldMove() {
        int randomValue = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        return randomValue >= MOVE_THRESHOLD;
    }
}
