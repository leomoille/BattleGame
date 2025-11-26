package games;

import controller.GameController;
import model.Deck;
import view.CommandLineView;

public class Game {
    public static void main(String[] args) {
        GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());
        gc.run();
    }
}
