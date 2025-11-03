package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.dto.ResultDto;
import lotto.service.LottoMachine;
import lotto.service.LottoResultCalculator;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoResultCalculator resultCalculator;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.resultCalculator = new LottoResultCalculator();
    }

    public void run() {
        int purchaseAmount = InputHandler.getPurchaseAmount();
        LottoTicket lottoTicket = lottoMachine.buyTickets(purchaseAmount);
        OutputView.printPurchasedLottos(lottoTicket);

        List<Integer> winningNumbers = InputHandler.getWinningNumbers();
        int bonusNumber = InputHandler.getBonusNumber(winningNumbers);

        ResultDto result = resultCalculator.analyzeResults(lottoTicket, winningNumbers, bonusNumber);
    }
}
