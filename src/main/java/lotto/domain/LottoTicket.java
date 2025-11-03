package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return lottos.size();
    }

    public List<String> formattedLottos() {
        return lottos.stream()
                .map(Lotto::formatted)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
