package org.lennan.refresher.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
//        List<Integer> coinDenominations = List.of(25, 10, 5, 1);
        List<Integer> coinDenominations = List.of(5, 2, 1);
        Integer value = 7;
        System.out.println(coinChange(value, coinDenominations));
    }

    private static int coinChange(Integer value, List<Integer> coinDenominations) {
        Integer denomination = coinDenominations.get(0);
        List<Integer> remainingDenomination = coinDenominations.subList(1, coinDenominations.size());
        Integer maxCoins = value / denomination;
        Integer ways = maxCoins + 1;
        for (int coin = 0; coin <= maxCoins; coin++) {
            Integer remaining = value - (denomination * coin);
            if (remaining > 0)
                ways += coinChange(remaining, remainingDenomination);
        }

        System.out.println(denomination + " " + ways);
        return ways;
    }
}
