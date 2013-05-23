package example.mastermind;

import org.junit.Before;
import org.junit.Test;

public class GameRulesTest {
  private GameRules g;

  @Before
    public void setUp() {
    g = new GameRules();
  }

  @Test
  public void testGameOverWhenMatchAndMovesRemaining() {
    String[][] move  = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2 = new String[][] { {"r", "r", "r", "r"}, {"b", "b", "b", "b"} };

    String[][][] moveHistory = new String[][][] { move, move2 };

    assert(g.gameOver(moveHistory) == true);
  }

  @Test
  public void testGameOverWhenNoMatchAndNoMoreMoves() {
    String[][] move   = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move3  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move4  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move5  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move6  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move7  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move8  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move9  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move10 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move11 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move12 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };

    String[][][] moveHistory = new String[][][] { move, move2, move3, move4, move5, move6, move7, move8, move9, move10, move11, move12 };

    assert(g.gameOver(moveHistory) == true);
  }

  @Test
  public void testGameOverWhenMatchAndNoMoreMoves() {
    String[][] move   = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move3  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move4  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move5  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move6  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move7  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move8  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move9  = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move10 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move11 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };
    String[][] move12 = new String[][] { {"r", "r", "r", "r"}, {"b", "b", "b", "b"} };

    String[][][] moveHistory = new String[][][] { move, move2, move3, move4, move5, move6, move7, move8, move9, move10, move11, move12 };

    assert(g.gameOver(moveHistory) == true);
  }

  @Test
  public void testGameOverWhenNoMatchAndMovesRemaining() {
    String[][] move  = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };

    String[][][] moveHistory = new String[][][] { move, move2 };

    assert(g.gameOver(moveHistory) == false);
  }
}