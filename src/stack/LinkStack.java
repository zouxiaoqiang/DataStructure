package stack;

public class LinkStack<E> implements Stack<E> {
    private class Node<E> {
        E data;
        Node<E> next;

        public Node() {
            this(null);
        }

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    // top指针指向栈顶元素
    private Node<E> top;
    private int size = 0;

    public LinkStack() {
        top = new Node();
    }

    @Override
    public boolean isEmpty() {
        return top.next == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void clear() {
        Node<E> tmp = top.next;
        while (tmp != null) {
            tmp.data = null;
            tmp = tmp.next;
        }
        size = 0;
        top.next = null;
    }

    @Override
    public void push(E elem) {
        Node<E> newNode = new Node<>(elem);
        newNode.next = top.next;
        top.next = newNode;
        size++;
    }

    @Override
    public E top() {
        if (top.next == null) return null;
        return top.next.data;
    }

    @Override
    public E pop() {
        if (top.next == null) return null;
        E elem = top.next.data;
        top.next.data = null;
        top.next = top.next.next;
        size--;
        return elem;
    }

    @Override
    public void traverse() {
        Node<E> tmp = top;
        while ((tmp = tmp.next) != null)
            System.out.print(tmp.data + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new LinkStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        System.out.println(s.top());
        s.push(6);
        s.traverse();
    }
}
