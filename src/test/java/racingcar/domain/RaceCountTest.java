package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경주 횟수 도메인 테스트")
class RaceCountTest {

    @Test
    @DisplayName("숫자가 아닌 입력시 예외 발생")
    void 숫자가_아닌_입력시_예외_발생() {
        // given
        String nonNumericInput = "ab";

        // when
        Throwable thrown = catchThrowable(() -> new RaceCount(nonNumericInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("양의 정수를 입력해주세요.");
    }
}
