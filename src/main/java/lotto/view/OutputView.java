package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.dto.ResultDto;

import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchasedLottos(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.lottoCount() + "개를 구매했습니다.");

        for (String lottoString : lottoTicket.formattedLottos()) {
            System.out.println(lottoString);
        }
    }

    public static void printResult(ResultDto result, Double profitRate) {
        printResultHeader();
        printResultContents(result, profitRate);
    }

    private static void printResultHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private static void printResultContents(ResultDto result, Double profitRate) {
        Map<Rank, Integer> results = result.results();
        List<Rank> printOrder = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

        for (Rank rank : printOrder) {
            int count = results.get(rank);
            String prizeFormatted = String.format("%,d", rank.prize());

            if (rank == MISS) {
                continue;
            }
            if (rank == SECOND) {
                System.out.println(rank.matchCount() + "개 일치, 보너스 볼 일치 (" + prizeFormatted + "원) - " + count + "개");
                continue;
            }
            System.out.println(rank.matchCount() + "개 일치 (" + prizeFormatted + "원) - " + count + "개");
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
