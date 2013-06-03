package example.mastermind;

import java.util.ArrayList;
import java.util.List;

public class MockIo implements Io {

  public List<String> messages;
  public List<String> guesses;
  public List<String> playAgainResponses;
  private int guessIndex;
  private int playAgainIndex;

  public MockIo(List<String> guesses, List<String> playAgainResponses) {
    messages = new ArrayList<String>();

    guessIndex = 0;
    this.guesses = guesses;

    this.playAgainResponses = playAgainResponses;
    playAgainIndex = 0;
  }

  @Override
  public void display(String message) {
    messages.add(message);
  }

  @Override
  public String getsGuess() {
    return guesses.get(guessIndex++);
  }

  @Override
  public String getsPlayAgain() {
    return playAgainResponses.get(playAgainIndex++);
  }

}
