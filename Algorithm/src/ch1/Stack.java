package ch1;

import java.util.Iterator;

/**
 * @author xiaoq
 * @date 18-4-26
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    private class Node {
        Item data;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        Node oldfirst = first;
        first = new Node();
        first.data = item;
        first.next = oldfirst;
        size++;
    }

    public Item pop() {
        if (first == null) {
            throw new NullPointerException("stack is empty");
        }
        Item item = first.data;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            Item item = node.data;
            node = node.next;
            return item;
        }
    }

}

class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("li");
        stack.pop();
        stack.pop();
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
