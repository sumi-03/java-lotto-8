package lotto.controller;

import java.util.List;

public class LottoController {
    public void run() {

        int purchaseAmount = InputHandler.getPurchaseAmount();

        // 로또 발행

        List<Integer> winningNumbersInput = InputHandler.getWinningNumbers();
        int bonusNumber = InputHandler.getBonusNumber();
    }
}
