package org.samples;

public class Poker {
    public static Hand whoWins(Hand h1, Hand h2) {
        final Card highCard1 = h1.cards.max(c -> c.rank.getRankValue());
        final Card highCard2 = h2.cards.max(c -> c.rank.getRankValue());
        final int c = highCard1.compareTo(highCard2);
        if(c < 0)
            return h2;
        if(0 < c)
            return h1;
        return null;
    }
}
