package example.mastermind;

import java.util.Arrays;
import java.util.Random;

public class SystemSecretCode implements SecretCode {

  public String[] symbols;
  public Integer numberOfAvailableSymbols;
  public Integer secretCodeLength;

  public SystemSecretCode() {
    symbols = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    numberOfAvailableSymbols = 6;
    secretCodeLength = 4;
  }

  @Override
  public String[] generate() {
    String[] secretCode = new String[secretCodeLength];

    Random random = new Random();

    for(int i = 0; i < secretCodeLength; i++) {
      secretCode[i] = availableSymbols()[random.nextInt(availableSymbols().length)];
    }

    return secretCode;
  }

  public String[] availableSymbols() {
    return Arrays.copyOfRange(symbols, 0, numberOfAvailableSymbols);
  }

}
