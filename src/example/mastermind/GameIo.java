package example.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameIo {

  private final Io io;
  private int      spacePerCharacter;
  private String   border;

  public GameIo(Io io) {
    this.io = io;
    this.spacePerCharacter = 7;
    this.border = "|";
  }

  public void displayWelcomeMessage() {
    io.display("\nWelcome to Mastermind!  Get ready to play!");
  }

  public String[] guess(int guessesRemaining, String[] availableSymbols, int secretCodeLength) {
    String[] guess = displayAndGetGuess(guessesRemaining, availableSymbols);

    while ( validateGuess(guess, availableSymbols, secretCodeLength) == false ) {
      displayInvalidInputMessage();
      guess = guess(guessesRemaining, availableSymbols, secretCodeLength);
    }

    return guess;
  }

  public String[] displayAndGetGuess(int guessesRemaining, String[] availableSymbols) {
    displayGuessPrompt(guessesRemaining, availableSymbols);
    return getGuess();
  }

  public void displayGuessPrompt(int guessesRemaining, String[] availableSymbols) {
    String prompt = String.format("You have %d guesses remaining.\n"
        + "Please enter your guess from the following options:\n"
        + "%s (Example: rgyb)\n", guessesRemaining, Arrays.toString(availableSymbols));
    io.display(prompt);
  }

  public String[] getGuess() {
    return io.getsGuess().split("(?!^)");
  }

  public Boolean validateGuess(String[] guess, String[] availableSymbols, int secretCodeLength) {
    if ( guess.length == secretCodeLength && compareAvailableSymbolsToGuesses(availableSymbols, guess) )
      return true;
    else
      return false;
  }

  private Boolean compareAvailableSymbolsToGuesses(String[] validResponses, String[] response) {
    for (int i = 0; i < response.length; i++) {
        if (contains(validResponses, response[i]) == false)
          return false;
    }

    return true;
  }

  private Boolean contains(String[] validResponses, String responsePart) {
    for (int i = 0; i < validResponses.length; i++) {
      if ( responsePart.equals(validResponses[i]) )
        return true;
    }
    return false;
  }

  public void displayInvalidInputMessage() {
    io.display("Your input was invalid.  Please try again.");
  }

  public void displayWinMessage() {
    io.display("Woohoo!  You win!");
  }

  public void displayLoseMessage() {
    io.display("You lose.  Better luck next time.");
  }

  public String playAgain() {
    String response = displayAndGetPlayAgain().toLowerCase();

    while ( validatePlayAgain(response) == false ) {
      displayInvalidInputMessage();
      response = playAgain();
    }

    return response;
  }

  public String displayAndGetPlayAgain() {
    displayPlayAgainPrompt();
    return getPlayAgain();
  }

  public void displayPlayAgainPrompt() {
    io.display("Would you like to play again? (y/n)\n");
  }

  public String getPlayAgain() {
    return io.getsPlayAgain();
  }

  public Boolean validatePlayAgain(String response) {
    if ( response.equals("y") || response.equals("n") )
      return true;
    else
      return false;
  }

  public void displayGameboard(ArrayList<String[][]> moveHistory) {
    io.display(constructGameboard(moveHistory));
  }

  public String constructGameboard(ArrayList<String[][]> moveHistory) {
    return    boardHeader()
            + boardHeadings()
            + board_row(moveHistory)
            + boardFooter();
  }

  private String boardHeader() {
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

  private String boardHeadings() {
    return    "|                TURN               |             FEEDBACK              |\n"
            + "|                                   |                                   |\n"
            + " ----------------------------------------------------------------------- \n"
            + "|                                   |                                   |\n";
    }

  private String board_row(ArrayList<String[][]> moveHistory) {
    String row = "";

    for (int i=0; i<moveHistory.size(); i++) {
      row += border;
      row += parseMove(moveHistory.get(i)) + "\n";
    }

    return row;
  }

  private String parseMove(String[][] move) {
    String moveString = "";

    for (int i=0; i<move.length; i++) {
      moveString += parseMovePart(move[i]);
      moveString += middleBorder();
    }

    return moveString;
  }

  private String parseMovePart(String[] part) {
    String movePart = "";


    for (int i=0; i<part.length; i++) {
      if (part[i] != null)
        movePart += String.format("%1$" + spacePerCharacter + "s", part[i]);
      else
        movePart += String.format("%1$" + spacePerCharacter + "s", " ");
    }
    return movePart;
  }

  private String middleBorder() {
      return String.format("%1$" + (spacePerCharacter+1) + "s", border);
  }

  public String boardFooter() {
    return   "|                                   |                                   |\n"
           + " ----------------------------------------------------------------------- \n";
    }

}