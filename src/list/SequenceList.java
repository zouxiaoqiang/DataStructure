package list;


import java.util.Arrays;

public class SequenceList<E> implements List<E> {
    private final int ADD_SIZE = 10;
    private int capacity = 10;
    private int size = 0;
    private Object[] data;

    public Object[] getData() {
        return data;
    }

    public SequenceList() {
        data = new Object[this.capacity];
    }

    public SequenceList(int length) {
        capacity = length;
        data = new Object[capacity];
    }

    private void addCapacity() {
        capacity += ADD_SIZE;
        data = Arrays.copyOf(data, capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    public E get(int index) {
        if (index < 1 || index > size) {
            System.out.println("invalid index");
            return null;
        }
        return (E) data[index - 1];
    }

    @Override
    public void set(int index, E elem) {
        if (index < 1 || index > size) return;
        data[index - 1] = elem;
    }

    public int locate(E elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem))
                return i + 1;
        }
        return 0;
    }

    public void add(E elem) {
        add(size + 1, elem);
    }

    public void add(int index, E elem) {
        if (index < 1 || index > size + 1) {
            System.out.println("invalid index");
            return;
        }
        if (size == capacity) {
            addCapacity();
        }
        for (int i = size; i > index - 1; i--)
            data[i] = data[i - 1];
        data[index - 1] = elem;
        size++;
    }

    public E remove() {
        return remove(size);
    }

    public E remove(int index) {
        if (index < 1 || index > size) {
            System.out.println("Invalid index");
            return null;
        }
        E elem = (E) data[index - 1];
        for (int i = index; i < size; i++)
            data[i - 1] = data[i];
        size--;
        return elem;
    }

    // 得到this和r的并集
    public void union(SequenceList<E> r) {
        int lenR = r.length();
        for (int i = 0; i < lenR; i++) {
            E dataR = (E) r.getData()[i];
            if (locate(dataR) == 0)
                add(size + 1, dataR);
        }
    }

    public void traverse() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        SequenceList<Integer> list1 = new SequenceList<>();
        SequenceList<Integer> list2 = new SequenceList<>();
        for (int i = 0; i < 6; i++) {
            list1.add(i * 2);
            list2.add(i * 2 + 1);
        }
        list1.add(1, -1);
        list2.add(-2);
        list2.remove(1);
        list1.remove();
        list1.traverse();
        list2.traverse();
        list1.union(list2);
        list1.traverse();
    }
}
