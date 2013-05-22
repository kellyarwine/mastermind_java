package example.mastermind;

import java.util.Arrays;

public class Feedback {

    public String[] feedback = new String[4];
    public String[] guess = new String[4];
    public String[] secretCode = new String[4];

    public void get(String[] passedGuess, String[] passedSecretCode) {
        make_guess_public(passedGuess);
        make_secret_code_public(passedSecretCode);
        find_exact_matches();
        find_near_matches();
        find_no_matches();
        sort_feedback();
        }

    public void make_guess_public(String[] passedGuess) {
        for(int i = 0; i < passedGuess.length; i++) {
            guess[i] = passedGuess[i];
        }
    }

    public void make_secret_code_public(String[] passedSecretCode) {
        for(int i = 0; i < passedSecretCode.length; i++) {
            secretCode[i] = passedSecretCode[i];
        }
    }

    public void find_exact_matches() {
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == secretCode[i]) {
                    feedback[i] = "b";
                    guess[i] = "x";
                    secretCode[i] = "x";
            }
        }
    }

    public void find_near_matches() {
        for (int i = 0; i < guess.length; i++) {
            if ( Arrays.asList(secretCode).contains(guess[i]) && guess[i] != "x" ) {
                feedback[i] = "w";
                int matched_symbol_index = Arrays.asList(secretCode).indexOf(guess[i]);
                secretCode[matched_symbol_index] = "x";
            }
        }
    }

    public void find_no_matches() {
        for (int i = 0; i < guess.length; i++) {
            if ( feedback[i] == null ) {
                feedback[i] = " ";
            }
        }
    }

    public void sort_feedback() {
        Arrays.sort(feedback);
    }
}