package lotto.controller;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.InputValidator.validatePurchaseAmount;

public class InputHandler {

    private InputHandler() {
    }

    public static int getPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readLine("구입금액을 입력해 주세요.");
                validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readLine("\n당첨 번호를 입력해 주세요.");
                // 검증하기
                // 일단 더미데이터 반환
                List<Integer> numbers = new ArrayList<>();
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                String input = InputView.readLine("\n보너스 번호를 입력해 주세요.");
                // 검증하기
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
