package example.mastermind;

import java.util.ArrayList;
import java.util.List;

public class MockDisplayer implements Displayer {

  public List messages;

  public MockDisplayer() {
    this.messages = new ArrayList();
  }

  @Override
  public void display(String message) {
    this.messages.add(message);
  }
}
