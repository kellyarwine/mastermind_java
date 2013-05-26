package example.mastermind;

import java.util.ArrayList;

public class MockIo implements Io {

  public ArrayList<String> messages;
  public String[] output;
  private int index;

  public MockIo() {
    this.messages = new ArrayList();
    String guess1  = "aaaa";
    String guess2  = "abcd";
    String guess3  = "aaaa";
    String guess4  = "abcd";
    String guess5  = "abcd";
    String guess6  = "abcd";
    String guess7  = "abcd";
    String guess8  = "abcd";
    String guess9  = "abcd";
    String guess10 = "abcd";
    String guess11 = "abcd";
    String guess12 = "aaaa";
    this.output = new String[] { guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, guess10, guess11, guess12 };
    this.index = 0;
  }

  @Override
  public void display(String message) {
    this.messages.add(message);
  }

  @Override
  public String gets() {
    return output[index++];
  }

}
