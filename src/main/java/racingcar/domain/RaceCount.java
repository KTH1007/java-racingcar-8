package racingcar.domain;

import racingcar.domain.exception.ErrorMessage;

public class RaceCount {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 100;

    private final int count;

    public RaceCount(String input) {
        this.count = parseAndValidate(input);
    }

    public boolean hasMoreRound(int currentRound) {
        return currentRound < count;
    }

    private int parseAndValidate(String input) {
        validateEmpty(input);

        int parsedCount;
        try {
            parsedCount = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ErrorMessage.NOT_POSITIVE_NUMBER, input.trim()));
        }

        validateRange(parsedCount);
        return parsedCount;
    }

    private static void validateEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_COUNT);
        }
    }

    private static void validateRange(int racingCount) {
        if (racingCount < MIN_COUNT || racingCount > MAX_COUNT) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_RACE_COUNT, racingCount));
        }
    }
}
