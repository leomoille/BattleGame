package controller;

import model.Deck;
import model.Player;
import model.PlayingCard;

import view.View;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed;
    }

    Deck deck;
    List<Player> players;
    Player winner;
    View view;
    GameState gameState;

    public GameController(Deck deck, View view) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        this.gameState = GameState.AddingPlayers;
        this.view.setController(this);
    }

    public void run() {
        while (this.gameState == GameState.AddingPlayers) {
            this.view.promptForPlayerName();
        }

        switch (this.gameState) {
            case CardsDealt -> this.view.promptForFlip();
            case WinnerRevealed -> this.view.promptForNewGame();
        }
    }

    public void addPlayer(String playerName) {
        if (this.gameState == GameState.AddingPlayers) {
            this.players.add(new Player(playerName));
            this.view.showPlayerName(players.size(), playerName);
        }
    }

    public void startGame() {
        if (this.gameState != GameState.CardsDealt) {
            this.deck.shuffle();
            int playerIndex = 1;
            for (Player player : this.players) {
                player.addCardToHand(deck.removeTopCard());
                this.view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            this.gameState = GameState.CardsDealt;
        }
        this.run();
    }

    public void flipCards() {
        int playerIndex = 1;
        for (Player player : players) {
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }

    void evaluateWinner() {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard pc = player.getCard(0);
                int thisRank = pc.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (pc.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard pc = player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }

        winner = bestPlayer;
    }

    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCard());
        }
    }

}
