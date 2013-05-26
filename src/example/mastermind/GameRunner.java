package example.mastermind;

public class GameRunner {

  public static void main(String[] args) {
    GameIo gameIo = new GameIo(new SystemIo());

    do {
      Game game = new Game(gameIo, new SystemSecretCode());
      game.playGame();
    } while (gameIo.playAgain().equals("y"));
  }

}

