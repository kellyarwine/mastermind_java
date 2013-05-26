package example.mastermind;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;


public class GameIntegrationTest extends TestCase {

  public void testGameWhereFirstGuessWinsGame() throws Exception{
    String[] secretCode = new String[] { "a", "a", "a", "a" };

    String guess1  = "aaaa";
    String[] guesses = new String[] { guess1 };

    String playAgain1  = "N";
    String[] playAgainResponses = new String[] { playAgain1 };

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
    String[] secretCode = new String[] { "a", "a", "b", "b" };

    String guess1  = "bbaa";
    String guess2  = "aabb";
    String[] guesses = new String[] { guess1, guess2 };

    String playAgain1  = "N";
    String[] playAgainResponses = new String[] { playAgain1 };

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
    String[] secretCode = new String[] { "a", "a", "b", "b" };

    String guess1  = "bbaa";
    String guess2  = "bbaa";
    String guess3  = "abcd";
    String guess4  = "abcd";
    String guess5  = "abcd";
    String guess6  = "abcd";
    String guess7  = "abcd";
    String guess8  = "abcd";
    String guess9  = "abcd";
    String guess10 = "abcd";
    String guess11 = "abcd";
    String guess12 = "abcd";
    String[] guesses = new String[] { guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, guess10, guess11, guess12 };

    String playAgain1  = "N";
    String[] playAgainResponses = new String[] { playAgain1 };

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
    assertThat(((MockIo) mockIo).messages.get(7), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(8), "You have 9 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(9), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(10), "You have 8 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(11), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(12), "You have 7 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(13), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(14), "You have 6 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(15), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(16), "You have 5 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(17), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(18), "You have 4 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(19), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(20), "You have 3 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(21), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(22), "You have 2 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(23), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(24), "You have 1 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo) mockIo).messages.get(25), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(26), "You lose.  Better luck next time.");
  }

  public void testGameWhere7GuessesWinsGameAnd2GuessesAreInvalidMoves() throws Exception{
    String[] secretCode = new String[] { "a", "a", "b", "b" };

    String guess1  = "azaa";
    String guess2  = "bbaa";
    String guess3  = "abcd";
    String guess4  = ".";
    String guess5  = "abcd";
    String guess6  = "abcd";
    String guess7  = "aabb";
    String[] guesses = new String[] { guess1, guess2, guess3, guess4, guess5, guess6, guess7 };

    String playAgain1  = "N";
    String[] playAgainResponses = new String[] { playAgain1 };

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
    assertThat(((MockIo)   mockIo).messages.get(7), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(8), "You have 10 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo) mockIo).messages.get(9),  "Your input was invalid.  Please try again.");
    assertEquals(((MockIo) mockIo).messages.get(10), "You have 10 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(11), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(12), "You have 9 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(13), containsString("|      a      b      c      d       |                    b      w       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(14), "You have 8 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertThat(((MockIo)   mockIo).messages.get(15), containsString("|      a      a      b      b       |      b      b      b      b       |\n"));
    assertEquals(((MockIo) mockIo).messages.get(16), "Woohoo!  You win!");
  }


}


//    for (int i=0; i < ((MockIo) mockIo).messages.size(); i++) {
//      System.out.print(((MockIo) mockIo).messages.get(i));
//    }


//assertEquals(((MockIo)mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
//assertEquals(((MockIo)mockIo).messages.get(0), "Would you like to play again? (y/n)\n");
//
//assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
//
//assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
//assertEquals(((MockIo)mockIo).messages.get(0), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
//assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
//assertEquals(((MockIo)mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
//assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
//assertEquals(((MockIo)mockIo).messages.get(3), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
//assertEquals(((MockIo)mockIo).messages.get(4), "Your input was invalid.  Please try again.");
//assertEquals(((MockIo)mockIo).messages.get(5), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
//
//
//assertEquals(((MockIo)mockIo).messages.get(0), "Your input was invalid.  Please try again.");
//assertEquals(((MockIo)mockIo).messages.get(0), "Woohoo!  You win!");
//assertEquals(((MockIo)mockIo).messages.get(0), "You lose.  Better luck next time.");
//
//assertThat(((MockIo) mockIo).messages.get(0), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
//assertThat(((MockIo) mockIo).messages.get(0), containsString("|                TURN               |             FEEDBACK              |\n"));
//assertThat(((MockIo) mockIo).messages.get(0), containsString("|                                   |                                   |\n"));
//assertThat(((MockIo) mockIo).messages.get(0), containsString(" ----------------------------------------------------------------------- \n"));
//
//assertThat(((MockIo) mockIo).messages.get(0), containsString("|      p      p      p      p       |                                   |\n"));
//assertThat(((MockIo) mockIo).messages.get(0), containsString("|      r      r      r      r       |      b      b      b      b       |\n"));

//String guess1  = "azza";
//String guess2  = "abcd";
//String guess3  = "aaag";
//String guess4  = "abcd";
//String guess5  = "abcd";
//String guess6  = "abcd";
//String guess7  = "abcd";
//String guess8  = "abcd";
//String guess9  = "abcd";
//String guess10 = "abcd";
//String guess11 = "abcd";
//String guess12 = "aaaa";
//this.guesses = new String[] { guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, guess10, guess11, guess12 };


//String playAgain1  = "yes";
//String playAgain2  = "no";
//String playAgain3  = ".";
//String playAgain4  = "AAA";
//String playAgain5  = "rrr";
//String playAgain6  = "N";
//playAgainResponses = new String[] { playAgain1, playAgain2, playAgain3, playAgain4, playAgain5, playAgain6 };
