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
        assertThat(thrown.getMessage()).isEqualTo("입력값 'ab'는(은) 유효한 숫자가 아닙니다. 양의 정수만 입력해주세요.");
    }

    @Test
    @DisplayName("null 입력시 예외 발생")
    void null_입력시_예외_발생() {
        // given
        String nullInput = null;

        // when
        Throwable thrown = catchThrowable(() -> new RaceCount(nullInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("경주 횟수가 비어있습니다.");
    }

    @Test
    @DisplayName("1 미만의 횟수시 예외 발생")
    void 일_미만의_횟수시_예외_발생() {
        // given
        String belowMinInput = "0";

        // when
        Throwable thrown = catchThrowable(() -> new RaceCount(belowMinInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("경주 횟수 '0'는(은) 유효하지 않습니다. 1~100 사이여야 합니다.");
    }

    @Test
    @DisplayName("100 초과의 횟수시 예외 발생")
    void 백_초과의_횟수시_예외_발생() {
        // given
        String aboveMaxInput = "101";

        // when
        Throwable thrown = catchThrowable(() -> new RaceCount(aboveMaxInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("경주 횟수 '101'는(은) 유효하지 않습니다. 1~100 사이여야 합니다.");
    }

    @Test
    @DisplayName("빈 문자열 입력시 예외 발생")
    void 빈_문자열_입력시_예외_발생() {
        // given
        String emptyInput = "";

        // when
        Throwable thrown = catchThrowable(() -> new RaceCount(emptyInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("경주 횟수가 비어있습니다.");
    }
}
