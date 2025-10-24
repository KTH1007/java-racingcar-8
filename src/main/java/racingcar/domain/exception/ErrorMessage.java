package racingcar.domain.exception;

public final class ErrorMessage {
    // NameExtractor 관련
    private static final String EMPTY_NAME = "자동차 이름이 비어있습니다.";
    private static final String DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";

    // Car 관련
    private static final String NAME_LENGTH_EXCEEDED = "자동차 이름은 5자 이하여야 합니다.";

    // RaceCount 관련
    private static final String NOT_POSITIVE_NUMBER = "입력값 '%s'는(은) 유효한 숫자가 아닙니다. 양의 정수만 입력해주세요.";
    private static final String EMPTY_COUNT = "경주 횟수가 비어있습니다.";
    private static final String INVALID_RACE_COUNT = "경주 횟수 '%d'는(은) 유효하지 않습니다. 1~100 사이여야 합니다.";

    // Cars 관련
    private static final String EMPTY_CAR_LIST = "자동차 목록이 비어있습니다.";

    public static IllegalArgumentException emptyName() {
        return new IllegalArgumentException(EMPTY_NAME);
    }

    public static IllegalArgumentException duplicateName() {
        return new IllegalArgumentException(DUPLICATE_NAME);
    }

    public static IllegalArgumentException nameLengthExceeded() {
        return new IllegalArgumentException(NAME_LENGTH_EXCEEDED);
    }

    public static IllegalArgumentException invalidNumber(String input) {
        return new IllegalArgumentException(String.format(NOT_POSITIVE_NUMBER, input));
    }

    public static IllegalArgumentException emptyCount() {
        return new IllegalArgumentException(EMPTY_COUNT);
    }

    public static IllegalArgumentException invalidRaceCount(int count) {
        return new IllegalArgumentException(String.format(INVALID_RACE_COUNT, count));
    }

    public static IllegalArgumentException emptyCarList() {
        return new IllegalArgumentException(EMPTY_CAR_LIST);
    }

    // 인스턴스 생성 방지
    private ErrorMessage() {
    }
}
