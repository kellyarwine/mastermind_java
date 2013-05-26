package example.mastermind;

import java.util.Scanner;

public class SystemIo implements Io {


  @Override
  public void display(String message) {
    System.out.println(message);
  }

  @Override
  public String getsGuess() {
    Scanner scan = new Scanner(System.in);
    return scan.next();
  }

  @Override
  public String getsPlayAgain() {
    Scanner scan = new Scanner(System.in);
    return scan.next();
  }

}
