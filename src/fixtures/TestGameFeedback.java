package fixtures;

import example.mastermind.*;

import java.util.ArrayList;
import java.util.List;

public class TestGameFeedback {

  private String secretCode;
  private String guess;
  private List guesses;
  private Feedback theFeedback;

  public TestGameFeedback() {
    guesses = new ArrayList<String>();
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }

  public void setGuess(String guess) {
      this.guess = guess;
  }

  public String feedback() {
    theFeedback = new Feedback();

    String[] feedback = theFeedback.get(guess.split("(?!^)"), secretCode.split("(?!^)"));

    StringBuffer result = new StringBuffer();

    for (int i = 0; i < feedback.length; i++) {
      result.append( feedback[i] );
    }

    return result.toString().trim();
  }

}