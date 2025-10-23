package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 목록 도메인 테스트")
class CarsTest {

    @Test
    @DisplayName("빈 자동차 목록으로 생성시 예외 발생")
    void 빈_자동차_목록으로_생성시_예외_발생() {
        // given
        List<Car> emptyCarList = List.of();

        // when
        Throwable thrown = catchThrowable(() -> new Cars(emptyCarList));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("자동차 목록이 비어있습니다.");
    }

    @Test
    @DisplayName("null 자동차 목록으로 생성시 예외 발생")
    void null_자동차_목록으로_생성시_예외_발생() {
        // given
        List<Car> nullCarList = null;

        // when
        Throwable thrown = catchThrowable(() -> new Cars(nullCarList));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("자동차 목록이 비어있습니다.");
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
        assertThat(thrown.getMessage()).isEqualTo("경주 횟수는 1~100 사이여야 합니다.");
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
        assertThat(thrown.getMessage()).isEqualTo("경주 횟수는 1~100 사이여야 합니다.");
    }
}
