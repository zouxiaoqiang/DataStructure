package stack;

public interface Stack<E> {
    boolean isEmpty();
    int length();
    void clear();
    void push(E elem);
    E top();
    E pop();
    void traverse();
}
