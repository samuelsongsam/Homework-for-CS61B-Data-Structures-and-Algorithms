import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.*/
    static CharacterComparator offByOne = new OffByOne();


    // Your tests go here.
    @Test
    public void testCharacterComparator() {
        assertTrue(offByOne.equalChars('x', 'y'));
        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('X', 'x'));
        assertFalse(offByOne.equalChars(',', ' '));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('A', 'b'));
    }
}
