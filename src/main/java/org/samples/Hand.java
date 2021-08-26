package org.samples;

import com.spun.util.StringUtils;
import org.lambda.query.Query;
import org.lambda.query.Queryable;

import java.util.Arrays;

public class Hand {
    public Queryable<Card> cards;

    public Hand(Card... cards) {
        this.cards = Queryable.as(cards);
    }

    public Hand(String handText) {
        final String[] s1 = handText.split(" ");
        this.cards = Query.select(s1, s -> new Card(s));

    }

    @Override
    public String toString() {
        return "[" + StringUtils.join(cards, " ") +"]";
    }
}
