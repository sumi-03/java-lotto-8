package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.dto.ResultDto;

import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;
import static lotto.util.ViewMessage.*;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchasedLottos(LottoTicket lottoTicket) {
        System.out.printf(PURCHASE_RESULT, lottoTicket.lottoCount());
        System.out.println();
        for (String lottoString : lottoTicket.formattedLottos()) {
            System.out.println(lottoString);
        }
    }

    public static void printResult(ResultDto result, Double profitRate) {
        printResultHeader();
        printResultContents(result, profitRate);
    }

    private static void printResultHeader() {
        System.out.println(RESULT_HEADER_TITLE);
        System.out.println(RESULT_HEADER_DIVIDER);
    }

    private static void printResultContents(ResultDto result, Double profitRate) {
        Map<Rank, Integer> results = result.results();
        List<Rank> printOrder = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

        for (Rank rank : printOrder) {
            if (rank == MISS) {
                continue;
            }
            printRankLine(rank, results.get(rank));
        }

        System.out.printf(TOTAL_PROFIT_RATE + "%n", profitRate);
    }

    private static void printRankLine(Rank rank, int count) {
        String prizeFormatted = String.format("%,d", rank.prize());

        if (rank == SECOND) {
            System.out.printf(MATCH_WITH_BONUS_RESULT + "%n",
                    rank.matchCount(), prizeFormatted, count);
            return;
        }

        System.out.printf(MATCH_RESULT + "%n",
                rank.matchCount(), prizeFormatted, count);
    }
}
