package org.samples;

import org.lambda.query.OrderBy;
import org.lambda.query.Query;
import org.lambda.query.Queryable;

import java.util.Map;
import java.util.stream.Collectors;

public class TwoPair implements EvaluateHand {

    @Override
    public Hand getWinner(Hand h1, Hand h2) {
        // check for pair
        var p1 = checkForTwoPair(h1);
        var p2 = checkForTwoPair(h2);
        // compare pairs
        if (p1 == null & p2 == null) {
            return null;
        }
        if (p1 == null){
            return h2;
        }  if (p2 == null){
            return h1;
        }
        if(wins(p1,p2))
            return h1;
        if(wins(p2,p1))
            return h2;
        return null;
    }

    private boolean wins(Queryable<Rank> p1, Queryable<Rank> p2) {
        var r1 = p1.select(p -> p.getRankValue());
        var r2 = p2.select(p -> p.getRankValue());
        return (r2.get(0) < r1.get(0)) || (r2.get(0) == r1.get(0) && r2.get(1) < r1.get(1));
    }

    private Queryable<Rank> checkForTwoPair(Hand h1) {
        Map<Rank, Long> result =
                h1.cards.stream().collect(
                        Collectors.groupingBy(c-> c.rank, Collectors.counting()              )
                );

        var pairs = Query.where(result.entrySet(), e -> e.getValue() == 2L);
        if (pairs.size() != 2) {
            return null;
        }
        return pairs.select(e -> e.getKey()).orderBy(OrderBy.Order.Descending, r -> r.getRankValue());
    }
}
