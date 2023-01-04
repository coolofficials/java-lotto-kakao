package view;

import buyer.BuyerProfit;
import buyer.BuyerResult;
import lotto.LotteryDTO;
import lotto.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void printLotteries(List<LotteryDTO> lotteries) {
        lotteries.forEach(this::printLottery);
    }

    private void printLottery(LotteryDTO lottery) {
        System.out.println(lottery);
    }

    public void printResult(BuyerResult result) {
        Arrays.stream(Rank.values()).forEach((e) -> {
            if (e != Rank.NONE) {
                printRankInfo(e);
                System.out.println(result.getRankCount(e) + "개");
            }
        });
    }

    private void printRankInfo(Rank rank) {
        System.out.print(rank.match.getMatchCount() + "개 일치");
        if (rank.equals(Rank.SECOND))
            System.out.print(", 보너스볼 일치");
        System.out.print("(" + rank.prize + ")- ");
    }

    public void printProfit(BuyerProfit buyerProfit) {
        System.out.println("총 수익률은 " + buyerProfit.getProfit() + "입니다");
    }
}