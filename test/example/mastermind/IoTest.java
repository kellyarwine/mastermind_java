package example.mastermind;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class IoTest {
    private Io io;

    @Before
    public void setUp() {
        io = new Io();
    }

    @Test
    public void testDisplay() {
        String result = "";
        String a = "I love ";
        String b = "my ";
        String c = "dogs!";
        result += a;
        result += b;
        result += c;

//        String result = "I love my dogs!";
        assertEquals(result, a + b + c);
    }

}
