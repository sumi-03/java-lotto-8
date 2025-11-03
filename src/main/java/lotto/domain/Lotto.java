package lotto.domain;

import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

import static lotto.util.Constants.*;
import static lotto.util.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_COUNT.getMessage());
        }

        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }

        boolean outOfRange = numbers.stream()
                .anyMatch(n -> n < LOTTO_NUMBER_MIN || n > LOTTO_NUMBER_MAX);
        if (outOfRange) {
            throw new IllegalArgumentException(INVALID_WINNING_RANGE.getMessage());
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public String formatted() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
