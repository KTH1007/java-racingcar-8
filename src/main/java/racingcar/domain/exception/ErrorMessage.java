package racingcar.domain.exception;

public final class ErrorMessage {
    // NameExtractor 관련
    public static final String EMPTY_NAME = "자동차 이름이 비어있습니다.";
    public static final String DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";

    // Car 관련
    public static final String NAME_LENGTH_EXCEEDED = "자동차 이름은 5자 이하여야 합니다.";

    // RaceCount 관련
    public static final String NOT_POSITIVE_NUMBER = "입력값 '%s'는(은) 유효한 숫자가 아닙니다. 양의 정수만 입력해주세요.";
    public static final String EMPTY_COUNT = "경주 횟수가 비어있습니다.";
    public static final String INVALID_RACE_COUNT = "경주 횟수 '%d'는(은) 유효하지 않습니다. 1~100 사이여야 합니다.";

    // Cars 관련
    public static final String EMPTY_CAR_LIST = "자동차 목록이 비어있습니다.";

    // 인스턴스 생성 방지
    private ErrorMessage() {
    }
}
