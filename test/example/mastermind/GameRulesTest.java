package example.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    ArrayList<String[][]> moveHistory = new ArrayList<String[][]>();
    moveHistory.add(move);
    moveHistory.add(move2);

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


    ArrayList<String[][]> moveHistory = new ArrayList<String[][]>();
    moveHistory.add(move);
    moveHistory.add(move2);
    moveHistory.add(move3);
    moveHistory.add(move4);
    moveHistory.add(move5);
    moveHistory.add(move6);
    moveHistory.add(move7);
    moveHistory.add(move8);
    moveHistory.add(move9);
    moveHistory.add(move10);
    moveHistory.add(move11);
    moveHistory.add(move12);

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

    ArrayList<String[][]> moveHistory = new ArrayList<String[][]>();
    moveHistory.add(move);
    moveHistory.add(move2);
    moveHistory.add(move3);
    moveHistory.add(move4);
    moveHistory.add(move5);
    moveHistory.add(move6);
    moveHistory.add(move7);
    moveHistory.add(move8);
    moveHistory.add(move9);
    moveHistory.add(move10);
    moveHistory.add(move11);
    moveHistory.add(move12);

    assert(g.gameOver(moveHistory) == true);
  }

  @Test
  public void testGameOverWhenNoMatchAndMovesRemaining() {
    String[][] move  = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2 = new String[][] { {"r", "r", "r", "r"}, {" ", "b", "b", "b"} };

    ArrayList<String[][]> moveHistory = new ArrayList<String[][]>();
    moveHistory.add(move);
    moveHistory.add(move2);

    assert(g.gameOver(moveHistory) == false);
  }
}