package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        int purchaseAmount = InputHandler.getPurchaseAmount();
        LottoTicket lottoTicket = lottoMachine.buyTickets(purchaseAmount);
        // 로또 출력
        List<Integer> winningNumbersInput = InputHandler.getWinningNumbers();
        int bonusNumber = InputHandler.getBonusNumber();
    }
}
