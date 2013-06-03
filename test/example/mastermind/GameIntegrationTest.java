package example.mastermind;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;


public class GameIntegrationTest extends TestCase {

  public void testGameWhereFirstGuessWinsGame() throws Exception{
    String secretCode = "aaaa";

    List<String> guesses = new ArrayList<String>();
    guesses.add("aaaa");

    List<String> playAgainResponses = new ArrayList<String>();
    playAgainResponses.add("N");

    Io mockIo = new MockIo(guesses, playAgainResponses);
    GameIo gameIo = new GameIo(mockIo);
    Game game = new Game(gameIo, new MockSecretCode(secretCode));

    game.playGame();

    assertEquals(((MockIo) mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
      assertThat(((MockIo) mockIo).messages.get(1), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
      assertThat(((MockIo) mockIo).messages.get(1), containsString("|                TURN               |             FEEDBACK              |\n"));
      assertThat(((MockIo) mockIo).messages.get(1), containsString("|                                   |                                   |\n"));
      assertThat(((MockIo) mockIo).messages.get(1), containsString(" ----------------------------------------------------------------------- \n"));
    assertEquals(((MockIo) mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
      assertThat(((MockIo) mockIo).messages.get(3), containsString("|      a      a      a      a       |      b      b      b      b       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(4), "Woohoo!  You win!");
  }

  public void testGameWhereSecondGuessWinsGame() throws Exception{
    String secretCode = "aabb";

    List<String> guesses = new ArrayList<String>();
    guesses.add("bbaa");
    guesses.add("aabb");

    List<String> playAgainResponses = new ArrayList<String>();
    String playAgain1  = "N";
    playAgainResponses.add(playAgain1);

    Io mockIo = new MockIo(guesses, playAgainResponses);
    GameIo gameIo = new GameIo(mockIo);
    Game game = new Game(gameIo, new MockSecretCode(secretCode));

    game.playGame();

    assertEquals(((MockIo) mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
    assertThat(((MockIo) mockIo).messages.get(1), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
    assertThat(((MockIo) mockIo).messages.get(1), containsString("|                TURN               |             FEEDBACK              |\n"));
    assertThat(((MockIo) mockIo).messages.get(1), containsString("|                                   |                                   |\n"));
    assertThat(((MockIo) mockIo).messages.get(1), containsString(" ----------------------------------------------------------------------- \n"));
    assertEquals(((MockIo) mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(3), containsString("|      b      b      a      a       |      w      w      w      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(4), "You have 11 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(5), containsString("|      a      a      b      b       |      b      b      b      b       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(6), "Woohoo!  You win!");
  }

  public void testGameWhere12GuessesLosesGame() throws Exception{
    String secretCode = "aabb";

    List<String> guesses = new ArrayList<String>();
    guesses.add("bbaa");
    guesses.add("bbaa");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");

    List<String> playAgainResponses = new ArrayList<String>();
    playAgainResponses.add("N");

    Io mockIo = new MockIo(guesses, playAgainResponses);
    GameIo gameIo = new GameIo(mockIo);
    Game game = new Game(gameIo, new MockSecretCode(secretCode));

    game.playGame();

    assertEquals(((MockIo) mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
    assertThat(((MockIo) mockIo).messages.get(1), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
    assertThat(((MockIo) mockIo).messages.get(1), containsString("|                TURN               |             FEEDBACK              |\n"));
    assertThat(((MockIo) mockIo).messages.get(1), containsString("|                                   |                                   |\n"));
    assertThat(((MockIo) mockIo).messages.get(1), containsString(" ----------------------------------------------------------------------- \n"));
    assertEquals(((MockIo) mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(3), containsString("|      b      b      a      a       |      w      w      w      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(4), "You have 11 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(5), containsString("|      b      b      a      a       |      w      w      w      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(6), "You have 10 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(7), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(8), "You have 9 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(10), "You have 8 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(12), "You have 7 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(14), "You have 6 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(16), "You have 5 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(18), "You have 4 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(20), "You have 3 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(22), "You have 2 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(24), "You have 1 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));;
    assertEquals(((MockIo) mockIo).messages.get(26), "You lose.  Better luck next time.");
  }

  public void testGameWhere7GuessesWinsGameAnd2GuessesAreInvalidMoves() throws Exception{

    String secretCode = "aabb";

    List<String> guesses = new ArrayList<String>();
    guesses.add("azaa");
    guesses.add("bbaa");
    guesses.add("abcd");
    guesses.add(".");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("aabb");

    List<String> playAgainResponses = new ArrayList<String>();
    playAgainResponses.add("N");

    Io mockIo = new MockIo(guesses, playAgainResponses);
    GameIo gameIo = new GameIo(mockIo);
    Game game = new Game(gameIo, new MockSecretCode(secretCode));

    game.playGame();

    assertEquals(((MockIo) mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
    assertThat(((MockIo)   mockIo).messages.get(1), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
    assertThat(((MockIo)   mockIo).messages.get(1), containsString("|                TURN               |             FEEDBACK              |\n"));
    assertThat(((MockIo)   mockIo).messages.get(1), containsString("|                                   |                                   |\n"));
    assertThat(((MockIo)   mockIo).messages.get(1), containsString(" ----------------------------------------------------------------------- \n"));
    assertEquals(((MockIo) mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo) mockIo).messages.get(3), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo) mockIo).messages.get(4), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(5), containsString("|      b      b      a      a       |      w      w      w      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(6), "You have 11 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(7), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(8), "You have 10 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(7), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(10), "You have 10 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(7), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(12), "You have 9 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(7), containsString("|      a      b      c      d       |      b      w      x      x       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(14), "You have 8 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(15), containsString("|      a      a      b      b       |      b      b      b      b       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(16), "Woohoo!  You win!");
  }
}