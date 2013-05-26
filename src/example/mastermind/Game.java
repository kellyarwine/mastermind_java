package example.mastermind;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

  private GameIo gameIo;
  private GameSecretCode s;
  private GameRules r;
  private Feedback f;
  private ArrayList<String[][]> moveHistory;
  private String[] guess;
  private String[] feedback;


  public Game(GameIo gameIo, SecretCode sc) {
    this.gameIo = gameIo;
    s = new GameSecretCode(sc);
    r = new GameRules();
    f = new Feedback();
    moveHistory = new ArrayList<String[][]>();
  }

  public void playGame() {
    startGame();
    runGame();
    endGame();
  }

  public void startGame() {
    displayWelcomeMessage();
    getSecretCode();
  }

  public void runGame() {
    while (gameOver() == false) {
      displayGameboard();
      getGuess();
      getFeedback();
      saveMoveToMoveHistory();
    }
  }

  public void endGame() {
    displayGameboard();
    displayGameOutcomeMessage();
  }

  public void displayWelcomeMessage() {
    gameIo.displayWelcomeMessage();
  }

  public void getSecretCode() {
    s.get();
  }

  public boolean gameOver() {
    return r.gameOver(moveHistory);
  }

  public void displayGameboard() {
    gameIo.displayGameboard(moveHistory);
  }

  public void getGuess() {
    guess = gameIo.guess(r.totalMoves - moveHistory.size(), s.availableSymbols(), s.secretCodeLength);
  }

  public void getFeedback() {
    feedback = f.get(guess, s.secretCode);;
  }

  public void saveMoveToMoveHistory() {
    moveHistory.add(new String[][]{guess, feedback});
  }

  public void displayGameOutcomeMessage() {
    if (r.gameWin(moveHistory))
      displayWinMessage();
    else
      displayLoseMessage();
  }

  public void displayWinMessage() {
    gameIo.displayWinMessage();
  }

  public void displayLoseMessage() {
    gameIo.displayLoseMessage();
  }
}
