package org.samples;

public class Poker {
    public static Hand whoWins(Hand h1, Hand h2) {
        final EvaluateHand wins[] = {new HighCardWins()};
        return wins[0].getWinner(h1, h2);
    }

}
