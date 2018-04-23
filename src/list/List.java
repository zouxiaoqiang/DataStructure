package list;

public interface List<E> {
    boolean isEmpty();

    int length();

    Object get(int index);

    void set(int index, E elem); //设置第index个元素的值为elem

    int locate(E elem);

    void add(E elem);

    void add(int index, E elem);

    E remove();

    E remove(int index);

    void traverse();
}
