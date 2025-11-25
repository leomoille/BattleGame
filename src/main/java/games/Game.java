package games;

import controller.GameController;
import model.Deck;
import view.View;

public class Game {
    public static void main(String[] args) {
        GameController gc = new GameController(new Deck(), new View(), new LowCardGameEvaluator());
        gc.run();
    }
}
