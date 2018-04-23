package queue;

public class LinkQueue<E> implements Queue<E> {
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

    // first.next指向队列的首元素 last指向队列的尾元素
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkQueue() {
        first = new Node<>();
        last = new Node<>();
        first = last;
    }

    @Override
    public boolean isEmpty() {
        return last == first;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void push(E elem) {
        Node<E> newNode = new Node<>(elem);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        Node<E> tmp = first;
        while (tmp.next != last)
            tmp = tmp.next;
        E elem = last.data;
        last = tmp;
        last.next = null;
        size--;
        return elem;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return last.data;
    }

    @Override
    public void traverse() {
        Node<E> tmp = first.next;
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.peek());
        q.pop();
        q.traverse();
        while (!q.isEmpty())
            q.pop();
        q.traverse();
    }
}
