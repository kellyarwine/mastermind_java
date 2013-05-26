package example.mastermind;

import java.util.Arrays;
import java.util.Random;

public class GameSecretCode {

  private SecretCode sc;
  public String[] secretCode;
  public int secretCodeLength;

  public GameSecretCode(SecretCode sc) {
    this.sc = sc;
    secretCodeLength = 4;
  }

  public void get() {
    secretCode = sc.generate();
  }

  public String[] availableSymbols() {
    return sc.availableSymbols();
  }


}
