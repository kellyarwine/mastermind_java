package example.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class GameIoTest {
  private GameIo gameIo;
  private Io mockIo;

  @Before
  public void setUp() {
    String secretCode = "aabb";

    List<String> guesses = new ArrayList<String>();
    guesses.add("azza");
    guesses.add("abcd");
    guesses.add("aaag");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("abcd");
    guesses.add("aaaa");

    List<String> playAgainResponses = new ArrayList<String>();
    playAgainResponses.add("yes");
    playAgainResponses.add("n.");
    playAgainResponses.add(".");
    playAgainResponses.add("Ny");
    playAgainResponses.add("yy");
    playAgainResponses.add("N");
    playAgainResponses.add("abcd");
    playAgainResponses.add("abcd");
    playAgainResponses.add("abcd");
    playAgainResponses.add("abcd");
    playAgainResponses.add("abcd");
    playAgainResponses.add("aaaa");

    mockIo = new MockIo(guesses, playAgainResponses);
    gameIo = new GameIo(mockIo);
  }

  @Test
  public void testWelcomeMessageDisplay() {
    gameIo.displayWelcomeMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
  }

  @Test
  public void testGuessInput() {
    assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
    assertEquals(((MockIo)mockIo).messages.get(0), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
  }

  @Test
  public void test2GuessInputs() {
    assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
    assertEquals(((MockIo)mockIo).messages.get(0), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
    assertEquals(((MockIo)mockIo).messages.get(3), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo)mockIo).messages.get(4), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(5), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
  }

  @Test
  public void testInvalidInputMessageDisplay() {
    gameIo.displayInvalidInputMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "Your input was invalid.  Please try again.");
  }

  @Test
  public void testWinMessageDisplay() {
    gameIo.displayWinMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "Woohoo!  You win!");
  }

  @Test
  public void testLoseMessageDisplay() {
    gameIo.displayLoseMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "You lose.  Better luck next time.");
  }

  @Test
  public void testPlayAgainInput() {
    assertEquals(gameIo.playAgain(), "n");
    assertEquals(((MockIo)mockIo).messages.get(0), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(2), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(3), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(4), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(5), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(6), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(7), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(8), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(9), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(10), "Would you like to play again? (y/n)\n");
  }

  @Test
  public void testGameboardDisplay() {
    String[][] move  = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2 = new String[][] { {"r", "r", "r", "r"}, {"b", "b", "b", "b"} };

    ArrayList<String[][]> moveHistory = new ArrayList<String[][]>();
    moveHistory.add(move);
    moveHistory.add(move2);

    gameIo.displayGameboard(moveHistory);
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|                TURN               |             FEEDBACK              |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|      p      p      p      p       |                                   |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|      r      r      r      r       |      b      b      b      b       |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString(" ----------------------------------------------------------------------- \n"));
  }

}
