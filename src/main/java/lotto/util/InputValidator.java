package lotto.util;

import java.util.List;
import java.util.Set;

import static lotto.util.Constants.*;

public class InputValidator {
    public static void validatePurchaseAmount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amount = InputParser.parseInteger(input);

        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
        }
    }

    private static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    public static void validateWinningNumbers(String input) {
        List<Integer> numbers = InputParser.parseWinningNumbers(input);
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean hasOutOfRange = numbers.stream()
                .anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX);
        if (hasOutOfRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        int bonusNumber = InputParser.parseInteger(input);

        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
