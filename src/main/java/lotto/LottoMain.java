package lotto;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoWinningNumberList;
import lotto.domain.strategy.RandomNumberSelectStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new RandomNumberSelectStrategy());

        buyLotto(lottoGame);
        checkLotto(lottoGame);
    }

    private static void buyLotto(LottoGame lottoGame) {
        int money = InputView.getMoney();

        lottoGame.buy(money);
        ResultView.printQuantity(lottoGame.getCountOfLottoTickets());
        ResultView.print(lottoGame.getLottoTicketsString());
    }

    private static void checkLotto(LottoGame lottoGame) {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        LottoWinningNumberList lottoWinningNumbers
                = new LottoWinningNumberList(winningNumbers, bonusNumber);

        ResultView.print(lottoGame.getWinningString(lottoWinningNumbers));
    }
}