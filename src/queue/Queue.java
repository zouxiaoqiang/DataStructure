package queue;

public interface Queue<E> {
    boolean isEmpty();
    int length();
    void push(E elem);
    E pop();
    E peek();
    void traverse();
}
