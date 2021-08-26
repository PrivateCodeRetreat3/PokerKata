package org.samples;

import org.lambda.query.Query;

public class Poker {
    public static Hand whoWins(Hand h1, Hand h2) {
        final EvaluateHand wins[] = {new TwoPair(),new Pair(), new HighCardWins()};
        return Query.select(wins, s -> s.getWinner(h1, h2))
                .where(w-> w != null).first();
    }

}
