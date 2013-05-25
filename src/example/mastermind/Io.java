package example.mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class Io {

  public int    spacePerCharacter = 7;
  public String border = "|";

  private void display(String message) {
    System.out.println(message);
  }

  public void displayWelcomeMessage() {
    display("\nWelcome to Mastermind!  Get ready to play!");
  }

  public String gets() {
    Scanner scan = new Scanner(System.in);
    return scan.next();
  }

  public String[] displayMovePrompt(int movesRemaining, String[] availableSymbols) {
    String prompt = String.format("You have %d moves remaining.\n"
        + "Please enter your guess from the following options:\n"
        + "%s (Example: rgyb)\n", movesRemaining, Arrays.toString(availableSymbols));
    display(prompt);
    return getGuess();
  }

  public String[] getGuess() {
    return gets().split("(?!^)");
  }

  public void displayInvalidInputMessage() {
    display("Your input was invalid.  Please try again.");
  }

  public void displayWinMessage() {
    display("Woohoo!  You win!");
  }

  public void displayLoseMessage() {
    display("You lose.  Better luck next time.");
  }

  public void displayPlayAgainPrompt() {
    display("Would you like to play again? (y/n)");
  }

  public void displayGameboard(String[][][] moveHistory) {
    display(constructGameboard(moveHistory));
  }

  public String constructGameboard(String[][][] moveHistory) {
    return    boardHeader()
            + boardHeadings()
            + board_row(moveHistory)
            + boardFooter();
  }

  public String boardHeader() {
    return    "\n ----------------------------------------------------------------------- \n"
            + "|                                             .                         |\n"
            + "|                                           .o8                         |\n"
            + "|    ooo. .oo.  .oo.    .oooo.    .oooo.o .o888oo  .ooooo.  oooo d8b    |\n"
            + "|     888P Y88bP Y88b   P  )88b  d88(   8   888   d88   88b  888  8P    |\n"
            + "|     888   888   888   .oP 888    Y88b.    888   888ooo888  888        |\n"
            + "|     888   888   888  d8(  888  o.  )88b   888 . 888    .o  888        |\n"
            + "|    o888o o888o o888o  Y8888 8o 8oo888P'    888   Y8bod8P  d888b       |\n"
            + "|                                                                       |\n"
            + "|                                o8o                    .o8             |\n"
            + "|                                8o8                    888             |\n"
            + "|             ooo. .oo.  .oo.   oooo  ooo. .oo.    .oooo888             |\n"
            + "|              888P Y88bP Y88b  `888   888P Y88b  d88   888             |\n"
            + "|              888   888   888   888   888   888  888   888             |\n"
            + "|              888   888   888   888   888   888  888   888             |\n"
            + "|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"
            + " ----------------------------------------------------------------------- \n"
            + "|                                   |                                   |\n";
    }

  public String boardHeadings() {
    return    "|                TURN               |             FEEDBACK              |\n"
            + "|                                   |                                   |\n"
            + " ----------------------------------------------------------------------- \n"
            + "|                                   |                                   |\n";
    }

    public String board_row(String[][][] moveHistory) {
      String row = "";

      for (int i=0; i<moveHistory.length; i++) {
        row += border;
        row += parseMove(moveHistory[i]) + "\n";
      }

      return row;
    }

    public String parseMove(String[][] move) {
      String moveString = "";

      for (int i=0; i<move.length; i++) {
        moveString += parseMovePart(move[i]);
        moveString += middleBorder();
      }

      return moveString;
    }

    public String parseMovePart(String[] part) {
      String movePart = "";


      for (int i=0; i<part.length; i++) {
        if (part[i] != null)
          movePart += String.format("%1$" + spacePerCharacter + "s", part[i]);
        else
          movePart += String.format("%1$" + spacePerCharacter + "s", " ");
      }
      return movePart;
    }

    public String middleBorder() {
        return String.format("%1$" + (spacePerCharacter+1) + "s", border);
    }

  public String boardFooter() {
    return   "|                                   |                                   |\n"
           + " ----------------------------------------------------------------------- \n";
    }

}