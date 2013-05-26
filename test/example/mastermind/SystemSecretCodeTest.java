package example.mastermind;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
  public class SystemSecretCodeTest {
  private SystemSecretCode s;

  @Before
  public void setUp() {
    s = new SystemSecretCode();
  }

  @Test
  public void testAvailableSymbols() {
    String[] result = {"a","b","c","d","e","f"};
    assertArrayEquals(result, s.availableSymbols());
  }

  @Test
  public void testSecretCodeShouldHave4Symbols() {
    s.generate();
    assertTrue(s.generate().length == s.secretCodeLength);
  }

  @Test
  public void testSecretCodeShouldContainOnlyAvailableSymbols() {
    s.generate();
    for(int i = 0; i < s.secretCodeLength; ++i)
      assert( Arrays.asList(s.availableSymbols()).contains(s.generate()[i]) == true );
  }

  @Test
  public void testSecretCodeShouldBeRandom() {
    int duplicateCount = 0;
    String[][] generatedSecretCodes = new String[1000][s.secretCodeLength];

    for(int i = 0; i < 1000; ++i) {
      s.generate();
      System.arraycopy(s.generate(), 0, generatedSecretCodes[i], 0, s.generate().length);
    }

    for (int j=0; j<generatedSecretCodes.length; j++)
      for (int k=j+1; k<generatedSecretCodes.length; k++)
        if (generatedSecretCodes[k] == generatedSecretCodes[j])
            duplicateCount++;

    assert( duplicateCount == 0 );
  }

}