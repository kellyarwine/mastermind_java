package example.mastermind;

import java.util.Arrays;

public class GameRules {

  public int totalMoves = 12;

  public Boolean gameOver(String[][][] moveHistory) {
    return gameWin(moveHistory) || noMovesRemaining(moveHistory.length);
  }

  public Boolean gameWin(String[][][] moveHistory) {
    String[] lastFeedback = moveHistory[moveHistory.length-1][1];
//    if (lastFeedback != null)
//      Arrays.sort(lastFeedback);
    return Arrays.equals(lastFeedback, new String[]{"b", "b", "b", "b"});
  }

  public Boolean noMovesRemaining(int movesTaken) {
    return totalMoves - movesTaken == 0;
  }


}
