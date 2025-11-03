package lotto.util;

import java.util.List;
import java.util.Set;

import static lotto.util.Constants.*;
import static lotto.util.ErrorMessage.*;

public class InputValidator {
    public static void validatePurchaseAmount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_NOT_NUMERIC.getMessage());
        }

        int amount = InputParser.parseInteger(input);

        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
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
            throw new IllegalArgumentException(INVALID_WINNING_COUNT.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean hasOutOfRange = numbers.stream()
                .anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX);
        if (hasOutOfRange) {
            throw new IllegalArgumentException(INVALID_WINNING_RANGE.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(INVALID_BONUS_NOT_NUMERIC.getMessage());
        }

        int bonusNumber = InputParser.parseInteger(input);

        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(INVALID_BONUS_RANGE.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_WITH_WINNING.getMessage());
        }
    }
}
