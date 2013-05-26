package example.mastermind;

import java.util.ArrayList;

public class MockIo implements Io {

  public ArrayList<String> messages;
  public String[] guesses;
  private int guessIndex;
  public String[] playAgainResponses;
  private int playAgainIndex;

  public MockIo(String[] guesses, String[] playAgainResponses) {
    this.messages = new ArrayList();

    this.guesses = guesses;
    guessIndex = 0;

    this.playAgainResponses = playAgainResponses;
    playAgainIndex = 0;
  }

  @Override
  public void display(String message) {
    this.messages.add(message);
  }

  @Override
  public String getsGuess() {
    return guesses[guessIndex++];
  }

  @Override
  public String getsPlayAgain() {
    return playAgainResponses[playAgainIndex++];
  }

}
