package racingcar.domain;


import racingcar.domain.exception.ErrorMessage;

public class Car {
    private static final String POSITION_SYMBOL = "-";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.shouldMove()) {
            position++;
        }
    }

    public String createProgressDisplay() {
        return name + " : " + POSITION_SYMBOL.repeat(position);
    }

    public String createNameDisplay() {
        return name;
    }

    public boolean hasHigherPositionThan(Car other) {
        return this.position > other.position;
    }

    public boolean hasSamePositionAs(Car other) {
        return this.position == other.position;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_EXCEEDED);
        }
    }
}
