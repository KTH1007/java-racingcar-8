package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.ErrorMessage;

@DisplayName("자동차 목록 도메인 테스트")
class CarsTest {

    @Test
    @DisplayName("빈 자동차 목록으로 생성시 예외 발생")
    void 빈_자동차_목록으로_생성시_예외_발생() {
        // given
        List<Car> emptyCarList = List.of();

        // when & then
        assertThatThrownBy(() -> new Cars(emptyCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.emptyCarList().getMessage());
    }

    @Test
    @DisplayName("null 자동차 목록으로 생성시 예외 발생")
    void null_자동차_목록으로_생성시_예외_발생() {
        // given
        List<Car> nullCarList = null;

        // when & then
        assertThatThrownBy(() -> new Cars(nullCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.emptyCarList().getMessage());
    }
}
