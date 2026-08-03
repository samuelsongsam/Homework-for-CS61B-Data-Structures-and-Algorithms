public class LinkedListDeque<T> implements Deque<T> {

    private class Node {
        Node pre;
        T item;
        Node post;

        public Node() {
            pre = null;
            item = null;
            post = null;
        }

        public Node(Node previous, T i, Node posture) {
            pre = previous;
            item = i;
            post = posture;
        }

        public Node(T i) {
            pre = null;
            item = i;
            post = null;
        }

        public Node(Node previous, T i) {
            pre = previous;
            item = i;
            post = null;
        }

        public Node(T i, Node posture) {
            pre = null;
            item = i;
            post = posture;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.pre = sentinel;
        sentinel.post = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node nowNode = new Node(sentinel, item, sentinel.post);
        nowNode.post.pre = nowNode;
        nowNode.pre.post = nowNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node nowNode = new Node(sentinel.pre, item, sentinel);
        nowNode.post.pre = nowNode;
        nowNode.pre.post = nowNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node ptr = sentinel.post;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.post;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T toBerm = sentinel.post.item;
        sentinel.post = sentinel.post.post;
        sentinel.post.pre.post = null;
        sentinel.post.pre.pre = null;
        sentinel.post.pre = sentinel;
        size--;
        return toBerm;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node toBerm = sentinel.pre;
        sentinel.pre = toBerm.pre;
        toBerm.post = null;
        toBerm.pre = null;
        sentinel.pre.post = sentinel;
        size--;
        return toBerm.item;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node ptr = sentinel.post;
        for (int i = 0; i < index; i++) {
            ptr = ptr.post;
        }
        return ptr.item;
    }

    private T getRecursiveHelper(Node curNode, int index) {
        if (index == 0) {
            return curNode.item;
        }
        return getRecursiveHelper(curNode.post, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(sentinel.post, index);
    }
}
