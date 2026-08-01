public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[8];
        capacity = 8;
        size = 0;
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }


    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newItems = (T[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            newItems[i] = items[index];
        }
        items = newItems;
        head = 0;
        tail = size;
        capacity *= 2;
    }


    public void addFirst(T item) {
        if (isFull()) {
            resize();
        }
        head = (head - 1 + capacity) % capacity;
        items[head] = item;
        size++;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize();
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(items[index] + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    private void shrinkIfNeeded() {
        if (capacity > 8 && 4 * size < capacity) {
            T[] newItems = (T[]) new Object[capacity / 2];
            for (int i = 0; i < size; i++) {
                int index = (head + i) % capacity;
                newItems[i] = items[index];
            }
            capacity /= 2;
            head = 0;
            tail = size;
            items = newItems;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = items[head];
        items[head] = null;
        head = (head + 1) % capacity;
        size--;
        shrinkIfNeeded();
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        tail = (tail - 1 + capacity) % capacity;
        T res = items[tail];
        items[tail] = null;
        size--;
        shrinkIfNeeded();
        return res;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(head + index) % capacity];
    }
}
