package lotto.view;

import lotto.domain.LottoTicket;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchasedLottos(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.lottoCount() + "개를 구매했습니다.");

        for (String lottoString : lottoTicket.formattedLottos()) {
            System.out.println(lottoString);
        }
    }
}
