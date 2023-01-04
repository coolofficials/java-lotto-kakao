package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryDTO {
    private final List<Integer> numbers;

    public LotteryDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().map(number -> number.toString()).collect(Collectors.joining(","));
    }
}