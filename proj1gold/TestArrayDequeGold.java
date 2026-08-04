import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> stuDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solDeque = new ArrayDequeSolution<>();
        String message = "";

        for (int i = 0; i < 1000; i++) {
            int operation;

            if (solDeque.isEmpty()) {
                operation = StdRandom.uniform(2);
            } else {
                operation = StdRandom.uniform(4);
            }

            if (operation == 0) {
                Integer item = StdRandom.uniform(100);
                stuDeque.addFirst(item);
                solDeque.addFirst(item);
                message += "addFirst(" + item + ")\n";
            } else if (operation == 1) {
                Integer item = StdRandom.uniform(100);
                stuDeque.addLast(item);
                solDeque.addLast(item);
                message += "addLast(" + item + ")\n";
            } else if (operation == 2) {
                Integer expected = solDeque.removeFirst();
                Integer actual = stuDeque.removeFirst();
                message += "removeFirst()\n";
                assertEquals(message, expected, actual);
            } else {
                Integer expected = solDeque.removeLast();
                Integer actual = stuDeque.removeLast();
                message += "removeLast()\n";
                assertEquals(message, expected, actual);
            }
        }
    }
}
