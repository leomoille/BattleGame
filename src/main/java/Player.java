public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        super();
        this.name = name;
        this.hand = new Hand();
    }

    public void addCardToHand(PlayingCard pc) {
        hand.addCard(pc);
    }

    public PlayingCard getCard(int index) {
        return hand.getCrad(index);
    }

    public PlayingCard removeCard() {
        return hand.removeCard();
    }
}
