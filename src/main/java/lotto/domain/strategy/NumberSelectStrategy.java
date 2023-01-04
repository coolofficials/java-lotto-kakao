package lotto.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface NumberSelectStrategy {
    List<Integer> select();
}