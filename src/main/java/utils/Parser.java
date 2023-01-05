package utils;

import model.Lotto;
import model.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static Lotto parsingWinNumbers(final String input) {
        List<LottoNumber> lottoNumberList = Arrays.stream(input.replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
        return new Lotto(lottoNumberList);
    }

    public static LottoNumber parsingBonusNumber(final int input) {
        return LottoNumber.getLottoNumber(input);
    }

}