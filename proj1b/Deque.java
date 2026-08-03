public interface Deque<T> {




    /** put down all the method that should appear in a Deque kind */

    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
