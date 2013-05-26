package example.mastermind;

import java.util.ArrayList;

public class MockIo implements Io {

  public ArrayList<String> messages;
  public String[] guesses;
  private int guessIndex;
  public String[] playAgainResponses;
  private int playAgainIndex;

  public MockIo() {
    this.messages = new ArrayList();

    String guess1  = "azza";
    String guess2  = "abcd";
    String guess3  = "aaag";
    String guess4  = "abcd";
    String guess5  = "abcd";
    String guess6  = "abcd";
    String guess7  = "abcd";
    String guess8  = "abcd";
    String guess9  = "abcd";
    String guess10 = "abcd";
    String guess11 = "abcd";
    String guess12 = "aaaa";
    guesses = new String[] { guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, guess10, guess11, guess12 };
    guessIndex = 0;

    String playAgain1  = "yes";
    String playAgain2  = "no";
    String playAgain3  = ".";
    String playAgain4  = "AAA";
    String playAgain5  = "rrr";
    String playAgain6  = "N";
    playAgainResponses = new String[] { playAgain1, playAgain2, playAgain3, playAgain4, playAgain5, playAgain6 };
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
