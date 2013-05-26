package example.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class GameIoTest {
  private GameIo gameIo;
  private Io mockIo;

  @Before
  public void setUp() {
    mockIo = new MockIo();
    gameIo = new GameIo(mockIo);
  }

  @Test
  public void testWelcomeMessageDisplay() {
    gameIo.displayWelcomeMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
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

  @Test
  public void testGetsGuess() {
    assertArrayEquals(gameIo.getGuess(), new String[]{ "a", "a", "a", "a" } );
  }

  @Test
  public void test2Guesses() {
    assertArrayEquals(gameIo.getGuess(), new String[]{ "a", "a", "a", "a" } );
    assertArrayEquals(gameIo.getGuess(), new String[]{ "a", "b", "c", "d" } );
  }



}
