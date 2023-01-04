package domain.lotto;

import domain.lotto.ticket.LottoTicket;
import domain.lotto.ticket.generator.LottoTicketRandomGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LottoShopTest {

    @DisplayName("구매 금액에 맞는 로또 티켓 리스트를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {3_000, 1_001, 15_999})
    void buyLottoTickets(int money) {
        Cost cost = new Cost(money);
        LottoShop lottoShop = new LottoShop(new LottoTicketRandomGenerator());

        List<LottoTicket> lottoTickets = lottoShop.buyLottoTickets(cost);
        Assertions.assertThat(lottoTickets)
                .hasSize(money / LottoShop.LOTTO_PRICE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, LottoShop.LOTTO_PRICE - 1})
    @DisplayName("로또를 한 장도 못사는 경우에는 예외가 발생한다.")
    public void buyLottoTickets_throw(int money) {
        Cost cost = new Cost(money);
        LottoShop lottoShop = new LottoShop(new LottoTicketRandomGenerator());

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoShop.buyLottoTickets(cost));
    }
}