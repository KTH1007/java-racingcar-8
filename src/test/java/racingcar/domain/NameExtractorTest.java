package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.ErrorMessage;

class NameExtractorTest {

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void 빈_문자열_예외() {
        // given
        String emptyInput = "";

        // when & then
        assertThatThrownBy(() -> NameExtractor.extractCarNames(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME);
    }

    @Test
    @DisplayName("중복된 자동차 이름으로 생성시 예외 발생")
    void 중복된_자동차_이름으로_생성시_예외_발생() {
        // given
        String duplicateInput = "pobi, pobi, woni";

        // when
        Throwable thrown = catchThrowable(() -> NameExtractor.extractCarNames(duplicateInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("자동차 이름은 중복될 수 없습니다.");
    }
}
