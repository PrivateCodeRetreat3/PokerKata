package org.samples;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    void testCardDeck() {
        Approvals.verifyAll("card", Deck.all() );
    }

    @Test
    void testWinners() {
        Hand h1 = new Hand("A♦");
        Hand h2 = new Hand("K♦");
        Hand[] hands = {h1, h2};
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
