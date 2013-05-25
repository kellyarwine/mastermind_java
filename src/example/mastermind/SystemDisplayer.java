package example.mastermind;

public class SystemDisplayer implements Displayer{


  @Override
  public void display(String message) {
    System.out.println(message);
  }
}
