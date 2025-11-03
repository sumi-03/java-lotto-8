package lotto.controller;

import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.view.InputView;

import java.util.List;

import static lotto.util.ViewMessage.*;

public class InputHandler {
    private InputHandler() {
    }

    public static int getPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readLine(INPUT_PURCHASE_AMOUNT);
                InputValidator.validatePurchaseAmount(input);
                return InputParser.parseInteger(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readLine(INPUT_WINNING_NUMBERS);
                InputValidator.validateWinningNumbers(input);
                return InputParser.parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = InputView.readLine(INPUT_BONUS_NUMBER);
                InputValidator.validateBonusNumber(input, winningNumbers);
                return InputParser.parseInteger(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
