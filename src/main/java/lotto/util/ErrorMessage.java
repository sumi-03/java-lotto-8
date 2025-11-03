package lotto.util;

public enum ErrorMessage {

    INVALID_NUMBER("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_PURCHASE_NOT_NUMERIC("[ERROR] 구입 금액은 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다."),
    INVALID_WINNING_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 로또 번호에 중복이 있습니다."),
    INVALID_WINNING_RANGE("[ERROR] 로또 번호는 1~45 범위여야 합니다."),
    INVALID_BONUS_NOT_NUMERIC("[ERROR] 보너스 번호는 숫자여야 합니다."),
    INVALID_BONUS_RANGE("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_BONUS_WITH_WINNING("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}