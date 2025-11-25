package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<PlayingCard>();
    }

    public void addCard(PlayingCard pc) {
        this.cards.add(pc);
    }

    public PlayingCard getCrad(int index) {
        return this.cards.get(index);
    }

    public PlayingCard removeCard() {
        return this.cards.removeFirst();
    }
}
