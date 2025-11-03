package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.dto.ResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    private final LottoResultCalculator calculator = new LottoResultCalculator();

    @Test
    @DisplayName("당첨 번호와 보너스 번호를 기준으로 등수별 개수를 정확히 계산한다")
    void analyzeResults_정상작동() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 11, 12, 13)),
                new Lotto(List.of(10, 20, 30, 40, 41, 42))
        ));

        // when
        ResultDto result = calculator.analyzeResults(ticket, winningNumbers, bonusNumber);

        // then
        Map<Rank, Integer> results = result.results();
        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.MISS)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 상금 대비 수익률을 올바르게 계산한다")
    void calculateProfitRate_정상작동() {
        // given
        Map<Rank, Integer> resultMap = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.MISS, 0
        );
        ResultDto result = new ResultDto(resultMap);
        int purchaseAmount = 8000;

        // when
        double profitRate = calculator.calculateProfitRate(result, purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(25_000_000.0);
    }

    @Test
    @DisplayName("당첨이 없을 경우 수익률은 0이다")
    void calculateProfitRate_0원() {
        // given
        Map<Rank, Integer> resultMap = Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.MISS, 6
        );
        ResultDto result = new ResultDto(resultMap);
        int purchaseAmount = 6000;

        // when
        double profitRate = calculator.calculateProfitRate(result, purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(0.0);
    }
}
