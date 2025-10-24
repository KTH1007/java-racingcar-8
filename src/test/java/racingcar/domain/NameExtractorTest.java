package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
                .hasMessage(ErrorMessage.emptyName().getMessage());
    }

    @Test
    @DisplayName("중복된 자동차 이름으로 생성시 예외 발생")
    void 중복된_자동차_이름으로_생성시_예외_발생() {
        // given
        String duplicateInput = "pobi, pobi, woni";

        // when & then
        assertThatThrownBy(() -> NameExtractor.extractCarNames(duplicateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.duplicateName().getMessage());
    }
}
