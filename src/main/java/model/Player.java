package model;

public class Player implements IPlayer {
    private final String name;
    private final Hand hand;

    public Player(String name) {
        super();
        this.name = name;
        this.hand = new Hand();
    }

    public void addCardToHand(PlayingCard pc) {
        this.hand.addCard(pc);
    }

    public PlayingCard getCard(int index) {
        return this.hand.getCard(index);
    }

    public PlayingCard removeCard() {
        return this.hand.removeCard();
    }

    public String getName() {
        return this.name;
    }
}
