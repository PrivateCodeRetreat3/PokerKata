package org.samples;

import org.lambda.query.Query;

public enum Rank implements Comparable<Rank>{
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace;

    public static Rank fromText(String rankDigit) {
        return Query.first(values(), r -> rankDigit.equals(r.toString()));
    }

    @Override
    public String toString() {
        switch (this) {
            case Two:
                return "2";
            case Three:
                return "3";
            case Four:
                return "4";
            case Five:
                return "5";
            case Six:
                return "6";
            case Seven:
                return "7";
            case Eight:
                return "8";
            case Nine:
                return "9";
            case Ten:
                return "T";
            case Jack:
                return "J";
            case Queen:
                return "Q";
            case King:
                return "K";
            case Ace:
                return "A";
        }
        return null;  }
    public int getRankValue() {
        switch (this) {

            case Two:
                return 2;
            case Three:
                return 3;
            case Four:
                return 4;
            case Five:
                return 5;
            case Six:
                return 6;
            case Seven:
                return 7;
            case Eight:
                return 8;
            case Nine:
                return 9;
            case Ten:
                return 10;
            case Jack:
                return 11;
            case Queen:
                return 12;
            case King:
                return 13;
            case Ace:
                return 14;
        }
        return 0;
    }

}
