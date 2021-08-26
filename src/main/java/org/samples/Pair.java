package org.samples;

import org.lambda.query.Query;

import java.util.Map;
import java.util.stream.Collectors;

public class Pair implements EvaluateHand {
    @Override
    public Hand getWinner(Hand h1, Hand h2) {
        // check for pair
        var p1 = checkForPair(h1);
        var p2 = checkForPair(h2);
        // compare pairs
        if (p1 == null & p2 == null) {
            return null;
        }
        if (p1 == null){
            return h2;
        }  if (p2 == null){
            return h1;
        }
        if(p1.getRankValue() < p2.getRankValue())
            return h2;
        if(p2.getRankValue() < p1.getRankValue())
            return h1;
        return null;
    }

    private Rank checkForPair(Hand h1) {
        Map<Rank, Long> result =
            h1.cards.stream().collect(
                Collectors.groupingBy(c-> c.rank, Collectors.counting()              )
            );

        if (!result.values().contains(2L)){
            return null;
        }
        return Query.first(result.entrySet(), e -> e.getValue() == 2L).getKey();
    }
}
