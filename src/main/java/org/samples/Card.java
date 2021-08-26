package org.samples;

public class Card implements Comparable<Card> {

    public final Rank rank;
    public final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(String text) {
        String rankDigit = text.substring(0,1);
        String suitDigit = text.substring(1,2);
        rank = Rank.fromText(rankDigit);
        suit = Suit.fromText(suitDigit);
    }

    @Override
    public String toString() {
        return "" + rank +  suit + "";
    }

    @Override
    public int compareTo(Card that) {
        return this.rank.compareTo(that.rank);
    }
}
