package model;

public enum Suit {
    DIAMONDS(1), HEART(2), SPADES(3), CLUBS(4);

    final int suit;

    private Suit(int value) {
        this.suit = value;
    }

    public int value() {
        return this.suit;
    }
}
