import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy4 = new OffByN(4);
    static CharacterComparator offBy5 = new OffByN(5);
    static CharacterComparator offBy1 = new OffByN(1);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        //  n = 5
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('f', 'h'));
        //  n = 1
        assertTrue(offBy1.equalChars('f', 'e'));
        assertTrue(offBy1.equalChars('l', 'k'));
        assertFalse(offBy1.equalChars('a', 'a'));
        assertFalse(offBy1.equalChars('a', 'z'));
        assertTrue(offBy1.equalChars('&', '%'));
        //  n = 4
        assertTrue(offBy4.equalChars('b', 'f'));
    }

}
