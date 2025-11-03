package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.ErrorMessage.*;

public class InputParser {
    private InputParser() {
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputParser::parseInteger)
                .collect(Collectors.toList());
    }

    public static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }
}
