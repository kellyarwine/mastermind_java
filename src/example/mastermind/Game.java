package example.mastermind;

import java.util.Arrays;

public class Game {

  public Io gameIo = new Io();
  public SecretCode secretCode = new SecretCode();
  public GameRules gameRules = new GameRules();
  public Feedback feedback = new Feedback();
  public String[][][] moveHistory = new String[gameRules.totalMoves][2][secretCode.secretCodeLength];

  public void startGame() {
    gameIo.displayWelcomeMessage();
    secretCode.generate();
//    runGame();
  }

//  public void runGame() {
//    int i = 0;
//    while (gameRules.gameOver(moveHistory) == true) {
//      gameIo.displayGameboard(moveHistory);
//      String[] guessArray = gameIo.displayMovePrompt(gameRules.totalMoves, secretCode.availableSymbols());
//      System.out.print(Arrays.toString(secretCode.secretCode));
//      System.out.print("\n");
//      System.out.print(Arrays.toString(guessArray));
//      System.out.print("\n");
//      String[] feedbackArray = feedback.get(guessArray, secretCode.secretCode);
//      moveHistory[i++] = new String[][] { guessArray, feedbackArray };
//      System.out.print(Arrays.toString(feedbackArray));
//      System.out.print("\n");
//      System.out.print(Arrays.deepToString(moveHistory));
//    }
//  }

  public void endGame() {

  }

}
