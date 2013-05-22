package example.mastermind;

import java.util.Arrays;
import java.util.Random;

public class SecretCode {

    public String[] symbols = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public Integer numberOfAvailableSymbols = 6;
    public Integer secretCodeLength = 5;
    public String[] secretCode = new String[secretCodeLength];

    public void generate() {
        Random random = new Random();
        for(int i = 0; i < secretCodeLength; i++) {
            secretCode[i] = availableSymbols()[random.nextInt(availableSymbols().length)];
        }
    }

    public String[] availableSymbols() {
        String[] availableSymbolsArray = new String[numberOfAvailableSymbols];
        return Arrays.copyOfRange(symbols, 0, numberOfAvailableSymbols);
    }

}
