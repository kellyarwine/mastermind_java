package example.mastermind;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
  public class FeedbackTest {
    private Feedback f;

    @Before
    public void setUp() {
        f = new Feedback();
    }

    @Test
    public void testAllPerfectMatches() {
      ArrayList<String> guess = new ArrayList<String>();
      guess.add("c");
      guess.add("c");
      guess.add("c");
      guess.add("c");

      ArrayList<String> secretCode = new ArrayList<String>();
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");

      ArrayList<String> result = new ArrayList<String>();
      result.add("b");
      result.add("b");
      result.add("b");
      result.add("b");

      assertEquals(f.get(guess, secretCode), result);
    }

    @Test
    public void testThreePerfectMatches() {
      ArrayList<String> guess = new ArrayList<String>();
      guess.add("c");
      guess.add("c");
      guess.add("c");
      guess.add("d");

      ArrayList<String> secretCode = new ArrayList<String>();
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");

      ArrayList<String> result = new ArrayList<String>();
      result.add("b");
      result.add("b");
      result.add("b");
      result.add(" ");

      assertEquals(f.get(guess, secretCode), result);
    }

    @Test
    public void testTwoPerfectMatches() {
      ArrayList<String> guess = new ArrayList<String>();
      guess.add("c");
      guess.add("c");
      guess.add("d");
      guess.add("d");

      ArrayList<String> secretCode = new ArrayList<String>();
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");

      ArrayList<String> result = new ArrayList<String>();
      result.add("b");
      result.add("b");
      result.add(" ");
      result.add(" ");

      assertEquals(f.get(guess, secretCode), result);
    }

    @Test
    public void testOnePerfectMatch() {
      ArrayList<String> guess = new ArrayList<String>();
      guess.add("c");
      guess.add("d");
      guess.add("d");
      guess.add("d");

      ArrayList<String> secretCode = new ArrayList<String>();
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");
      secretCode.add("c");

      ArrayList<String> result = new ArrayList<String>();
      result.add("b");
      result.add(" ");
      result.add(" ");
      result.add(" ");

      assertEquals(f.get(guess, secretCode), result);
    }

  @Test
  public void testAllNoMatches() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("d");
    guess.add("d");
    guess.add("d");
    guess.add("d");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("c");
    secretCode.add("c");
    secretCode.add("c");
    secretCode.add("c");

    ArrayList<String> result = new ArrayList<String>();
    result.add(" ");
    result.add(" ");
    result.add(" ");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test1NearMatchAnd3NoMatches() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("d");
    guess.add("d");
    guess.add("d");
    guess.add("b");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("c");
    secretCode.add("c");
    secretCode.add("c");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("w");
    result.add(" ");
    result.add(" ");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test2NearMatchAnd2NoMatches() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("d");
    guess.add("d");
    guess.add("a");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("d");
    secretCode.add("c");
    secretCode.add("c");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("w");
    result.add("w");
    result.add(" ");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test3NearMatchAnd1NoMatches() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("d");
    guess.add("d");
    guess.add("b");
    guess.add("a");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("b");
    secretCode.add("c");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("w");
    result.add("w");
    result.add("w");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test4NearMatch() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("d");
    guess.add("d");
    guess.add("b");
    guess.add("b");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("b");
    secretCode.add("b");
    secretCode.add("d");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("w");
    result.add("w");
    result.add("w");
    result.add("w");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test1ExactMatch2NearMatchesAnd1NoMatch() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("c");
    guess.add("d");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("d");
    secretCode.add("e");
    secretCode.add("c");

    ArrayList<String> result = new ArrayList<String>();
    result.add("b");
    result.add("w");
    result.add("w");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test1ExactMatch1NearMatchAnd2NoMatch() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("c");
    guess.add("d");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("d");
    secretCode.add("e");
    secretCode.add("f");

    ArrayList<String> result = new ArrayList<String>();
    result.add("b");
    result.add("w");
    result.add(" ");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void test2ExactMatches1NearMatchAnd1NoMatch() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("c");
    guess.add("d");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("b");
    secretCode.add("e");
    secretCode.add("c");

    ArrayList<String> result = new ArrayList<String>();
    result.add("b");
    result.add("b");
    result.add("w");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void testDuplicateSymbolsinGuessButNotSecretCode() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("b");
    guess.add("c");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("b");
    secretCode.add("c");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("b");
    result.add("b");
    result.add("w");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void testDuplicateSymbolsinGuessButNotSecretCode2() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("a");
    guess.add("a");
    guess.add("a");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("b");
    secretCode.add("c");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("b");
    result.add(" ");
    result.add(" ");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("b");
    guess.add("c");
    guess.add("c");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("b");
    secretCode.add("a");
    secretCode.add("d");
    secretCode.add("e");
    secretCode.add("f");

    ArrayList<String> result = new ArrayList<String>();
    result.add("w");
    result.add("w");
    result.add(" ");
    result.add(" ");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode2() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("b");
    guess.add("c");
    guess.add("c");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("c");
    secretCode.add("c");
    secretCode.add("a");
    secretCode.add("b");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("w");
    result.add("w");
    result.add("w");
    result.add("w");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode3() {
    ArrayList<String> guess = new ArrayList<String>();
    guess.add("a");
    guess.add("b");
    guess.add("b");
    guess.add("c");

    ArrayList<String> secretCode = new ArrayList<String>();
    secretCode.add("a");
    secretCode.add("c");
    secretCode.add("b");
    secretCode.add("d");

    ArrayList<String> result = new ArrayList<String>();
    result.add("b");
    result.add("b");
    result.add("w");
    result.add(" ");

    assertEquals(f.get(guess, secretCode), result);
  }
}
