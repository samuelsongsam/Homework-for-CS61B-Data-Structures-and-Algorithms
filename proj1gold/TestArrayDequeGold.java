import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> stuDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solDeque = new ArrayDequeSolution<>();
        String message = "";

        for (int i = 0; i < 1000; i++) {
            if (solDeque.isEmpty()) {
                Integer operation = StdRandom.uniform(2);
                if (operation == 0) {
                    Integer addFirstItem = StdRandom.uniform(100);
                    stuDeque.addFirst(addFirstItem);
                    solDeque.addFirst(addFirstItem);
                } else {
                    Integer addLastItem = StdRandom.uniform(100);
                    stuDeque.addLast(addLastItem);
                    solDeque.addLast(addLastItem);
                }
            } else {
                Integer operation = StdRandom.uniform(4);
                switch (operation) {
                    case 0:
                        Integer addFirstItem = StdRandom.uniform(100);
                        stuDeque.addFirst(addFirstItem);
                        solDeque.addFirst(addFirstItem);
                        message += "Operation No." + i + ": addFirst(" + addFirstItem + ")\n";
                        break;
                    case 1:
                        Integer addLastItem = StdRandom.uniform(100);
                        stuDeque.addLast(addLastItem);
                        solDeque.addLast(addLastItem);
                        message += "Operation No." + i + ": addFirst(" + addLastItem + ")\n";
                        break;
                    case 2:
                        Integer stuRemoveFirst = stuDeque.removeFirst();
                        Integer solRemoveFirst = solDeque.removeFirst();
                        message += "Operation No." + i + ": removeFirst()\n";
                        assertEquals(stuRemoveFirst, solRemoveFirst);
                        break;
                    default:
                        Integer stuRemoveLast = stuDeque.removeLast();
                        Integer solRemoveLast = solDeque.removeLast();
                        message += "Operation No." + i + ": removeFirst()\n";
                        assertEquals(message, solRemoveLast, stuRemoveLast);
                }
            }
        }

    }
}
