package example.mastermind;

import java.util.Arrays;

public class Feedback {

  private String[] guess;
  private String[] secretCode;
  private String[] feedback;

  public String[] get(String[] guess, String[] secretCode) {
    this.guess = Arrays.copyOf(guess, guess.length);
    this.secretCode = Arrays.copyOf(secretCode, secretCode.length);
    this.feedback = new String[this.secretCode.length];
    findExactMatches();
    findNearMatches();
    findNoMatches();
    sortFeedback();
    return feedback;
  }

  private void findExactMatches() {
    for (int i = 0; i < guess.length; i++) {
      if (guess[i].equals(secretCode[i])) {
        feedback[i] = "b";
        guess[i] = "z";
        secretCode[i] = "z";
      }
    }
  }

  private void findNearMatches() {
    for (int i = 0; i < guess.length; i++) {
      int matchedSecretCodeIndex = secretCodeMatch(guess[i]);
      if ( matchedSecretCodeIndex != -1 && !guess[i].equals("z") ) {
        feedback[i] = "w";
        secretCode[matchedSecretCodeIndex] = "z";
      }
    }
  }

  private int secretCodeMatch(String guessSymbol) {
    int matchedIndex = -1;
    for (int i = 0; i < secretCode.length; i++) {
      if (guessSymbol.equals(secretCode[i]))
          matchedIndex = i;
    }
    return matchedIndex;
  }

  private void findNoMatches() {
    for (int i = 0; i < guess.length; i++) {
      if ( feedback[i] == null ) {
        feedback[i] = "x";
      }
    }
  }

  private void sortFeedback() {
    Arrays.sort(feedback);
  }
}