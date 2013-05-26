package example.mastermind;

import java.util.Scanner;

public class SystemIo implements Io {


  @Override
  public void display(String message) {
    System.out.println(message);
  }

  @Override
  public String gets() {
    Scanner scan = new Scanner(System.in);
    return scan.next();
  }

}
