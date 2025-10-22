package racingcar.domain.exception;

public final class ErrorMessage {
    // NameExtractor 관련
    public static final String EMPTY_NAME = "자동차 이름이 비어있습니다.";
    public static final String DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";

    // Car 관련
    public static final String NAME_LENGTH_EXCEEDED = "자동차 이름은 5자 이하여야 합니다.";

    // RaceCount 관련 (예정)
    public static final String INVALID_RACE_COUNT = "시도 횟수는 1 이상이어야 합니다.";
    public static final String NOT_POSITIVE_NUMBER = "양의 정수를 입력해주세요.";

    // 인스턴스 생성 방지
    private ErrorMessage() {
    }
}
