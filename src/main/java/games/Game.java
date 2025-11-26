package games;

import controller.GameController;
import model.Deck;
// import view.CommandLineView;
import view.GameSwingView;

public class Game {
    public static void main(String[] args) {
        // CommandLineView clv = new CommandLineView();
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();

        GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());

        gc.run();
    }
}
