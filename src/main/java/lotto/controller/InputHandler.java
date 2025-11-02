package lotto.controller;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private InputHandler() {
    }

    public static int getPurchaseAmount() {
        String input = InputView.readLine("구입금액을 입력해 주세요.");
        // 검증하기
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        String input = InputView.readLine("\n당첨 번호를 입력해 주세요.");
        // 검증하기
        // 일단 더미데이터 반환
        List<Integer> numbers = new ArrayList<>();
        return numbers;
    }

    public static int getBonusNumber() {
        String input = InputView.readLine("\n보너스 번호를 입력해 주세요.");
        // 검증하기
        return Integer.parseInt(input);
    }
}
