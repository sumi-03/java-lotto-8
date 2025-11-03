package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        int purchaseAmount = InputHandler.getPurchaseAmount();
        LottoTicket lottoTicket = lottoMachine.buyTickets(purchaseAmount);
        OutputView.printPurchasedLottos(lottoTicket);

        List<Integer> winningNumbers = InputHandler.getWinningNumbers();
        int bonusNumber = InputHandler.getBonusNumber();
    }
}
