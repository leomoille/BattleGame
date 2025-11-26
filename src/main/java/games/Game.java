package games;

import controller.GameController;
import model.Deck;
// import view.CommandLineView;
import model.DeckFactory;
import model.DeckFactory.DeckType;
import view.GameSwingView;

public class Game {
    public static void main(String[] args) {
        // CommandLineView clv = new CommandLineView();
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();

        GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), gsv, new LowCardGameEvaluator());

        gc.run();
    }
}
