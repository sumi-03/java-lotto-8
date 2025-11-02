package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {

    @Test
    @DisplayName("금액이 1000원 단위의 양수이면 예외가 발생하지 않는다")
    void 유효한_구입금액() {
        assertDoesNotThrow(() -> InputValidator.validatePurchaseAmount("8000"));
    }

    @Test
    @DisplayName("금액이 숫자가 아니면 예외가 발생한다")
    void 숫자가_아닌_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액이 음수이면 예외가 발생한다")
    void 음수_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 0이면 예외가 발생한다")
    void 금액이_0이면_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다")
    void 천원단위_아니면_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 범위의 6개 숫자면 예외가 발생하지 않는다")
    void 유효한_당첨번호() {
        assertThatCode(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호가 6개 미만이면 예외가 발생한다")
    void 당첨번호_부족_예외() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6개 초과면 예외가 발생한다")
    void 당첨번호_초과_예외() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void 당첨번호_중복_예외() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다")
    void 당첨번호_숫자아님_예외() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,세,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    void 당첨번호_범위초과_예외() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
