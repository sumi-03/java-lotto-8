package lotto.controller;

import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.view.InputView;

import java.util.List;

public class InputHandler {
    private InputHandler() {
    }

    public static int getPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readLine("구입금액을 입력해 주세요.");
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
                String input = InputView.readLine("\n당첨 번호를 입력해 주세요.");
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
                String input = InputView.readLine("\n보너스 번호를 입력해 주세요.");
                InputValidator.validateBonusNumber(input, winningNumbers);
                return InputParser.parseInteger(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
