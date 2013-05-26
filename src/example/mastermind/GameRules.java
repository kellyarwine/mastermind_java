package example.mastermind;

import java.util.ArrayList;
import java.util.Arrays;

public class GameRules {

  public int totalMoves = 12;

  public Boolean gameOver(ArrayList<String[][]> moveHistory) {
    return gameWin(moveHistory) || noMovesRemaining(moveHistory.size());
  }

  public Boolean gameWin(ArrayList<String[][]> moveHistory) {
    if (!moveHistory.isEmpty()) {
      String[] lastFeedback = moveHistory.get(moveHistory.size()-1)[1];

      if (lastFeedback != null) {
        Arrays.sort(lastFeedback);
        return Arrays.equals(lastFeedback, new String[]{"b", "b", "b", "b"});
      }
        else
      return false;
    }
    else
      return false;
  }

  public Boolean noMovesRemaining(int movesTaken) {
    return totalMoves - movesTaken == 0;
  }


}
