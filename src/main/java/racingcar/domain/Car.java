package racingcar.domain;


import java.util.List;
import racingcar.domain.exception.ErrorMessage;

public class Car {
    private static final String POSITION_SYMBOL = "-";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_POSITION_SEPARATOR = " : ";

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
        return name + NAME_POSITION_SEPARATOR + POSITION_SYMBOL.repeat(position);
    }

    public void addNameToList(List<String> names) {
        names.add(name);
    }

    public boolean hasHigherPositionThan(Car other) {
        return this.position > other.position;
    }

    public boolean hasSamePositionAs(Car other) {
        return this.position == other.position;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw ErrorMessage.emptyName();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw ErrorMessage.nameLengthExceeded();
        }
    }
}
