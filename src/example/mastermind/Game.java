package example.mastermind;

import java.util.Arrays;

public class Game {

  public Io gameIo = new Io();
  public SecretCode secretCode = new SecretCode();
  public GameRules gameRules = new GameRules();
  public Feedback feedback = new Feedback();
  public String[][][] moveHistory = new String[gameRules.totalMoves][][];

  public void startGame() {
//    String[] guess = new String[]     {"b", "b", "b", "b"};
//    String[] feedback = new String[]  {"w", "w", "w", " "};
//    String[] guess2 = new String[]    {"p", "r", "o", "o"};
//    String[] feedback2 = new String[] {" ", " ", "b", "w"};
//
//    String[][] move = new String[][] { {"b", "b", "b", "b"}, {"w", "w", "w", " "} };
//    String[][] move2 = new String[][] { guess2, feedback2 };
//
//    String[][][] moveHistory = new String[][][] { move, move2 };

    gameIo.displayWelcomeMessage();
    secretCode.generate();
//    runGame();
  }

//  public void runGame() {
//    while gameRules.gameOver(moveHistory)
//    gameIo.displayGameboard(moveHistory);
//    gameIo.displayMovePrompt(gameRules.totalMoves, secretCode.availableSymbols());
//    char[] guessArray = gameIo.getGuess();
//    String[] feedbackArray = feedback.get(guessArray,secretCode.secretCode);
//    moveHistory[i] = new{ guessArray, feedbackArray };
//  }

  public void endGame() {

  }

}
