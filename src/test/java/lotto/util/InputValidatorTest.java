package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {
    private static final List<Integer> VALID_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("금액이 1000원 단위의 양수이면 예외가 발생하지 않는다")
    void 유효한_구입금액() {
        // given
        String input = "8000";

        // when & then
        assertDoesNotThrow(() -> InputValidator.validatePurchaseAmount(input));
    }

    @Test
    @DisplayName("금액이 숫자가 아니면 예외가 발생한다")
    void 숫자가_아닌_입력_예외() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 음수이면 예외가 발생한다")
    void 음수_입력_예외() {
        // given
        String input = "-1000";

        // when & then
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 0이면 예외가 발생한다")
    void 금액이_0이면_예외() {
        // given
        String input = "0";

        // when & then
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다")
    void 천원단위_아니면_예외() {
        // given
        String input = "1500";

        // when & then
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 범위의 6개 숫자면 예외가 발생하지 않는다")
    void 유효한_당첨번호() {
        // given
        String input = "1,2,3,4,5,6";

        // when & then
        assertThatCode(() -> InputValidator.validateWinningNumbers(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호가 6개 미만이면 예외가 발생한다")
    void 당첨번호_부족_예외() {
        // given
        String input = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6개 초과면 예외가 발생한다")
    void 당첨번호_초과_예외() {
        // given
        String input = "1,2,3,4,5,6,7";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void 당첨번호_중복_예외() {
        // given
        String input = "1,2,3,3,4,5";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다")
    void 당첨번호_숫자아님_예외() {
        // given
        String input = "1,2,세,4,5,6";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    void 당첨번호_범위초과_예외() {
        // given
        String input = "1,2,3,4,5,46";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다")
    void 보너스번호_숫자아님_예외() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, VALID_WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1 미만이면 예외가 발생한다")
    void 보너스번호_0이하_예외() {
        // given
        String input = "0";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, VALID_WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 45 초과이면 예외가 발생한다")
    void 보너스번호_45초과_예외() {
        // given
        String input = "46";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, VALID_WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void 보너스번호_중복_예외() {
        // given
        String input = "3";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, VALID_WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 정상 범위이고 중복되지 않으면 예외가 발생하지 않는다")
    void 유효한_보너스번호() {
        // given
        String input = "7";

        // when & then
        assertThatCode(() -> InputValidator.validateBonusNumber(input, VALID_WINNING_NUMBERS))
                .doesNotThrowAnyException();
    }
}
