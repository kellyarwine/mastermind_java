package fixtures;

import example.mastermind.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
  private String secretCode;
  private List<String> guesses;
  private List<String> expectedFeedbackValues;
  private List<String> playAgainResponses;
  private GameIo gameIo;
  private Game theGame;

  public PlayGame() {
    guesses = new ArrayList<String>();
    expectedFeedbackValues = new ArrayList<String>();
    playAgainResponses = new ArrayList<String>();
    playAgainResponses.add("N");

  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }

  public void setGuessAndExpectedFeedback(String guess, String expectedFeedback) {
    setGuess(guess);
    setExpectedFeedback(expectedFeedback, guess);
  }

  private void setGuess(String guess) {
    guesses.add(guess);
  }

  private void setExpectedFeedback(String expectedFeedback, String guess) {
    String[] availableSymbols = new String[] {"a","b","c","d","e","f"};
    if (guess.length() == 4 && compareAvailableSymbolsToGuesses(availableSymbols, guess.split("(?!^)")))
      expectedFeedbackValues.add(expectedFeedback);
  }

  private Boolean compareAvailableSymbolsToGuesses(String[] validResponses, String[] response) {
    for (int i = 0; i < response.length; i++) {
      if (contains(validResponses, response[i]) == false)
        return false;
    }

    return true;
  }

  private Boolean contains(String[] validResponses, String responsePart) {
    for (int i = 0; i < validResponses.length; i++) {
      if ( responsePart.equals(validResponses[i]) )
        return true;
    }
    return false;
  }

  public void startGame() {
    Io mockIo = new MockIo(guesses, playAgainResponses);
    gameIo = new GameIo(mockIo);
    theGame = new Game(gameIo, new MockSecretCode(this.secretCode));

    theGame.playGame();
  }

  public int numberOfGuessesMade() {
    return theGame.moveHistory.size();
  }

  public int numberOfInvalidMovesMade() {
    return guesses.size() - theGame.moveHistory.size();
  }

  public List guesses() {
    return guesses;
  }

  public List moveHistory() {
    return theGame.moveHistory;
  }

  public boolean gameOver() {
    return theGame.gameOver();
  }

  public boolean gameWin() {
    return theGame.r.gameWin(theGame.moveHistory);
  }

  public String actualFeedback() {
    String newString = "";

    for (int i=0; i< theGame.moveHistory.size(); i++)
      newString = newString + Arrays.toString(theGame.moveHistory.get(i)[1]);

    return newString;
  }

  public String expectedFeedback() {
    String string1;
    String string2 = "";

    for (int i=0; i<expectedFeedbackValues.size(); i++) {
      string1 = expectedFeedbackValues.get(i);
      String[] stringArray = string1.split("(?!^)");
      string2 += Arrays.toString(stringArray);
    }

    return string2;
  }

  public boolean expectedFeedbackCorrect() {
    for (int i=0; i<expectedFeedbackValues.size(); i++) {
      String[] actualFeedback = theGame.moveHistory.get(i)[1];
      String expectedFeedback = expectedFeedbackValues.get(i);

      if (!Arrays.equals(expectedFeedback.split("(?!^)"), actualFeedback))
        return false;
    }

    return true;
  }

}