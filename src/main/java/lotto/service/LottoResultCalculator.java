package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.dto.ResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public ResultDto analyzeResults(LottoTicket lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottoTicket.getLottos()) {
            Rank rank = Rank.valueOf(lotto.countMatchingNumbers(winningNumbers), lotto.contains(bonusNumber));
            result.put(rank, result.get(rank) + 1);
        }

        return new ResultDto(result);
    }

    public double calculateProfitRate(ResultDto result, int purchaseAmount) {
        int totalPrize = 0;
        Map<Rank, Integer> rankResults = result.results();

        for (Map.Entry<Rank, Integer> entry : rankResults.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.prize() * count;
        }

        return (double) totalPrize / purchaseAmount * 100;
    }
}
