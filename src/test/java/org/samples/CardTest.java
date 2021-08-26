package org.samples;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;
import org.lambda.query.Query;
import org.lambda.query.Queryable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    void testCardDeck() {
        Approvals.verifyAll("card", Deck.all() );
    }

    @Test
    void testWinners() {
        var handText = Queryable.as(
                "A♦",
                "K♦",
                "7♦ 7♣",
                "5♦ 5♣",
                "4♦ 4♣ 2♦ 2♣",
                "5♦ 5♣ 2♦ 2♣",
                "4♦ 4♣ 3♦ 3♣");
        var hands = handText.select(h -> new Hand(h)).asArray();
        CombinationApprovals.verifyAllCombinations((h11, h21) -> {
            if(h11 == h21)
            {
                throw new org.approvaltests.combinations.SkipCombination();
            }
            return Poker.whoWins(h11, h21);
        }, hands, hands);

    }

    @Test
    void testHighCardWins() {

        CombinationApprovals.verifyAllCombinations((c1, c2) -> {
            if(c1==c2)
            {
                throw new org.approvaltests.combinations.SkipCombination();
            }
            return Poker.whoWins(new Hand(c1),new Hand(c2));
        }, Deck.all(), Deck.all());

    }
}
