package stack;

import java.util.Arrays;

public class SequenceStack<E> implements Stack<E> {
    private int ADD_SIZE = 10;
    private Object[] data;
    // 栈顶指针
    private int top = -1;
    private int capacity = 10;

    public SequenceStack(){
        data = new Object[capacity];
    }

    public SequenceStack(int length){
        capacity = length;
        data = new Object[capacity];
    }

    private void addCapacity(){
        capacity += ADD_SIZE;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int length() {
        return top+1;
    }

    @Override
    public void clear() {
        Arrays.fill(data, null);
        top = -1;
    }

    @Override
    public void push(E elem) {
        if(top == capacity)
            addCapacity();
        data[++top] = elem;
    }

    @Override
    public E top() {
        if(top == -1) return null;
        return (E) data[top];
    }

    @Override
    public E pop() {
        if(top == -1) return null;
        E elem = (E) data[top];
        data[top--] = null;
        return elem;
    }

    @Override
    public void traverse() {
        for(int i = top; i > -1; i--)
            System.out.print(data[i] + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new SequenceStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        System.out.println(s.top());
        s.push(5);
        s.traverse();
    }
}
