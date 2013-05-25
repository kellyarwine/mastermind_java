package example.mastermind;

import java.util.ArrayList;

public class Feedback {

  private ArrayList<String> feedback;
  private ArrayList<String> guess;
  private ArrayList<String> secretCode;

  public ArrayList<String> get(ArrayList<String> guess, ArrayList<String> secretCode) {
    this.guess = guess;
    this.secretCode = secretCode;
    this.feedback = new ArrayList<String>();

    find_exact_matches();
    find_near_matches();
    find_no_matches();

    return feedback;
  }

  public void find_exact_matches() {
    for (int i = 0; i < guess.size(); i++) {
      if (guess.get(i) == secretCode.get(i)) {
        feedback.add("b");
        guess.set(i, "x");
        secretCode.set(i, "x");
      }
    }
  }

  public void find_near_matches() {
    for (int i = 0; i < guess.size(); i++) {
      if ( secretCode.contains(guess.get(i)) && guess.get(i) != "x" ) {
        feedback.add("w");
        int matched_symbol_index = secretCode.indexOf(guess.get(i));
        secretCode.set(matched_symbol_index, "x");
      }
    }
  }

  public void find_no_matches() {
    while (feedback.size() < guess.size()) {
      feedback.add(" ");
    }
  }
}