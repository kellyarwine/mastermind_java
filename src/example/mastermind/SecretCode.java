package example.mastermind;

public interface SecretCode {
  String[] generate();
  String[] availableSymbols();
}
