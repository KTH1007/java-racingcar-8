package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.ErrorMessage;

@DisplayName("경주 횟수 도메인 테스트")
class RaceCountTest {

    @Test
    @DisplayName("숫자가 아닌 입력시 예외 발생")
    void 숫자가_아닌_입력시_예외_발생() {
        // given
        String nonNumericInput = "ab";

        // when & then
        assertThatThrownBy(() -> new RaceCount(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.invalidNumber("ab").getMessage());
    }

    @Test
    @DisplayName("null 입력시 예외 발생")
    void null_입력시_예외_발생() {
        // given
        String nullInput = null;

        // when & then
        assertThatThrownBy(() -> new RaceCount(nullInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.emptyCount().getMessage());
    }

    @Test
    @DisplayName("1 미만의 횟수시 예외 발생")
    void 일_미만의_횟수시_예외_발생() {
        // given
        String belowMinInput = "0";

        // when & then
        assertThatThrownBy(() -> new RaceCount(belowMinInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.invalidRaceCount(0).getMessage());
    }

    @Test
    @DisplayName("100 초과의 횟수시 예외 발생")
    void 백_초과의_횟수시_예외_발생() {
        // given
        String aboveMaxInput = "101";

        // when & then
        assertThatThrownBy(() -> new RaceCount(aboveMaxInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.invalidRaceCount(101).getMessage());
    }

    @Test
    @DisplayName("빈 문자열 입력시 예외 발생")
    void 빈_문자열_입력시_예외_발생() {
        // given
        String emptyInput = "";

        // when & then
        assertThatThrownBy(() -> new RaceCount(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.emptyCount().getMessage());
    }
}
