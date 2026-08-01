import org.junit.Test;

public class ArrayDeque<T>{
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
    @SuppressWarnings("unchecked")
    public ArrayDeque(T it){
        items = (T[]) new Object[8];
        items[0] = it;
        capacity = 8;
        size = 1;
        head = 0;
        tail = 1;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == capacity;
    }


    @SuppressWarnings("unchecked")
    private void Resize(){
        T[] new_items =(T[]) new Object[capacity * 2];
        for(int i = 0; i < size; i++){
            int index = (head + i) % capacity;
            new_items[i] = items[index];
        }
        items = new_items;
        head = 0;
        tail = size;
        capacity *= 2;
    }


    public void addFirst(T item) {
        if (isFull()) {
            Resize();
        }
        head = (head - 1 + capacity) % capacity;
        items[head] = item;
        size++;
    }

    public void addLast(T item){
        if (isFull()){
            Resize();
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i=0;i<size;i++){
            int index =(head +i)%capacity;
            System.out.print(items[index]+" ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    private void shrink_if_needed(){
        if(capacity>8&&4*size<capacity){
            T[] new_items =(T[]) new Object[capacity/2];
            for(int i=0;i<size;i++){
                int index =(head+i)%capacity;
                new_items[i] = items[index];
            }
            capacity/=2;
            head=0;
            tail=size;
            items = new_items;
        }
        return;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T res = items[head];
        items[head]=null;
        head = (head + 1)%capacity;
        size--;
        shrink_if_needed();
        return res;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        tail = (tail-1+capacity)%capacity;
        T res = items[tail];
        items[tail]=null;
        size--;
        shrink_if_needed();
        return res;
    }

    public T get(int index){
        if(index>=size||index<0){
            return null;
        }
        return items[(head+index)%capacity];
    }


}
