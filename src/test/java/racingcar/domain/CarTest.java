package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.ErrorMessage;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void 자동차_이름이_5자를_초과하면_예외_발생() {
        // given
        String longName = "toolongname";

        // when & then
        assertThatThrownBy(() -> new Car(longName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.nameLengthExceeded().getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외 발생")
    void 자동차_이름이_null이면_예외_발생() {
        // given
        String nullName = null;

        // when & then
        assertThatThrownBy(() -> new Car(nullName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.emptyName().getMessage());
    }
}
