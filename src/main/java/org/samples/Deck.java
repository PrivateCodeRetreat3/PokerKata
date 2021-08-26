package org.samples;

import org.lambda.query.Query;
import org.lambda.query.Queryable;

public class Deck {

    public static Card[] all() {
        Queryable<Card> cards = new Queryable(Card.class);
        for (Rank rank: Rank.values()) {
            for (Suit suit: Suit.values()) {
                cards.add(new Card(rank,suit));
            }
        }
        return cards.asArray();
    }
}
