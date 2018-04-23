package queue;

import java.util.Arrays;

public class SequenceQueue<E> implements Queue<E> {
    private Object[] data;
    // first指向首元素 last指向尾元素
    private int first = 0;
    private int last = -1;
    private int capacity = 10;
    private int ADD_SIZE = 10;

    public SequenceQueue(){
        data = new Object[capacity];
    }

    public SequenceQueue(int length){
        capacity = length;
        data = new Object[capacity];
    }


    @Override
    public boolean isEmpty() {
        return last+1 == first;
    }

    @Override
    public int length() {
        return last-first+1;
    }

    private void addCapacity(){
        capacity += ADD_SIZE;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public void push(E elem) {
        if(last+1 == capacity)  addCapacity();
        data[++last] = elem;
    }

    @Override
    public E pop() {
        if(isEmpty())  return null;
        E elem = (E) data[first];
        data[first++] = null;
        return elem;
    }

    @Override
    public E peek() {
        if(isEmpty())  return null;
        return (E) data[first];
    }

    @Override
    public void traverse() {
        for(int i = first; i <= last; i++)
            System.out.print(data[i] + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new SequenceQueue<>(4);
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        System.out.println(q.length());
        q.pop();
        System.out.println(q.peek());
        q.traverse();
        while (!q.isEmpty())
            q.pop();
    }
}
