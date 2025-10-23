package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void 자동차_이름이_5자를_초과하면_예외_발생() {
        // given
        String longName = "toolongname";

        // when
        Throwable thrown = catchThrowable(() -> new Car(longName));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외 발생")
    void 자동차_이름이_null이면_예외_발생() {
        // given
        String nullName = null;

        // when
        Throwable thrown = catchThrowable(() -> new Car(nullName));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("자동차 이름이 비어있습니다.");
    }
}
