package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.dto.ResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public ResultDto calculate(LottoTicket lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottoTicket.getLottos()) {
            Rank rank = Rank.valueOf(lotto.countMatchingNumbers(winningNumbers), lotto.contains(bonusNumber));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return new ResultDto(result);
    }
}
