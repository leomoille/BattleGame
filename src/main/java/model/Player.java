package model;

public class Player {
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
        return this.hand.getCrad(index);
    }

    public PlayingCard removeCard() {
        return this.hand.removeCard();
    }
}
