package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.Constants.*;

public class LottoMachine {
    public LottoTicket buyTickets(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList())))
                .toList();
        return new LottoTicket(lottos);
    }
}
