package example.mastermind;

import java.util.Arrays;

public class MockSecretCode implements SecretCode {

  public String[] symbols;
  public Integer numberOfAvailableSymbols;
  public Integer secretCodeLength;

  public MockSecretCode() {
    symbols = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    numberOfAvailableSymbols = 6;
    secretCodeLength = 4;
  }

  @Override
  public String[] generate() {
    return new String[] { "a","a","a","a" };
  }

  public String[] availableSymbols() {
    return Arrays.copyOfRange(symbols, 0, numberOfAvailableSymbols);
  }

}
