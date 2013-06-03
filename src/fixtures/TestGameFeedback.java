package fixtures;

import example.mastermind.*;

import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.lang3.StringUtils;

public class TestGameFeedback {

  private String secretCode;
  private String guess;
  private List guesses;
  private Game theGame;
  private Feedback theFeedback;

  public TestGameFeedback() {
    guesses = new ArrayList<String>();
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }

  public void setGuess(String guess) {
//    guesses.add(guess);
      this.guess = guess;
  }

//  public void execute() {
//
//    List playAgainResponses = new ArrayList<String>();
//    playAgainResponses.add("N");
//
//    Io mockIo = new MockIo(guesses, playAgainResponses);
//    GameIo gameIo = new GameIo(mockIo);
//
//    theGame = new Game(gameIo, new MockSecretCode(this.secretCode));
//
//    theGame.playGame();
//  }

  public String feedback() {
//    String[][] lastTurn = theGame.moveHistory.get(theGame.moveHistory.size()-1);
//    String[]   lastFeedback = lastTurn[1];
//
//    StringBuffer result = new StringBuffer();
//
//    for (int i = 0; i < lastFeedback.length; i++) {
//      result.append( lastFeedback[i] );
//    }
//
//    return result.toString().trim();
////    return StringUtils.trim(StringUtils.join(lastFeedback));

    theFeedback = new Feedback();

    String[] feedback = theFeedback.get(guess.split("(?!^)"), secretCode.split("(?!^)"));

    StringBuffer result = new StringBuffer();

    for (int i = 0; i < feedback.length; i++) {
      result.append( feedback[i] );
    }

    return result.toString().trim();

  }


  public boolean gameOver() {
    return theGame.gameOver();
  }

}