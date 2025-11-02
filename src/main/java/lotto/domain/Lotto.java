package lotto.domain;

import java.util.List;
import java.util.HashSet;

import static lotto.util.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있습니다.");
        }

        boolean outOfRange = numbers.stream()
                .anyMatch(n -> n < LOTTO_NUMBER_MIN || n > LOTTO_NUMBER_MAX);
        if (outOfRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위여야 합니다.");
        }
    }
}
