package org.samples;

import org.lambda.query.Query;

public enum Suit {
    Clubs("♣"), Diamonds("♦"), Hearts("♥"), Spades("♦");

    private String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public static Suit fromText(String suitDigit) {
        return Query.first(values(), suit -> suitDigit.equals(suit.toString()));
    }

    @Override
    public String toString() {
        return symbol ;
    }
}
