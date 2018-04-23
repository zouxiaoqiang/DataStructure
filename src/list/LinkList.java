package list;


public class LinkList<E> implements List<E> {
    class Node<E> {
        private E data;
        private Node<E> next;

        public Node() {
            this(null);
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }
    }

    //head不存储元素, 指向首元素
    private Node<E> head;
    private int size = 0;

    public LinkList() {
        head = new Node<>();
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public int length() {
        return size;
    }

    private Node<E> getData(int index) {
        if (index < 1 || index > size) {
            System.out.println("Invalid index");
            return null;
        }
        Node<E> tmp = head.next;
        while (index > 1) {
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }

    public E get(int index) {
        return getData(index).getData();
    }

    public void set(int index, E elem) {
        Node<E> tmp = getData(index);
        tmp.data = elem;
    }

    public int locate(E elem) {
        Node<E> tmp = head.next;
        for (int index = 0; tmp != null; index++, tmp = tmp.next) {
            if (tmp.getData().equals(elem))
                return index + 1;
        }
        return 0;
    }

    public void add(E elem) {
        add(size + 1, elem);
    }

    public void add(int index, E elem) {
        Node<E> tmp;
        if (index == 1)
            tmp = head;
        else if ((tmp = getData(index - 1)) == null)
            return;
        Node<E> newNode = new Node<>(elem);
        newNode.next = tmp.next;
        tmp.next = newNode;
        size++;
    }

    public E remove() {
        return remove(size);
    }

    public E remove(int index) {
        Node<E> tmp;
        if (index == 1)
            tmp = head;
        else if ((tmp = getData(index - 1)) == null)
            return null;
        Node<E> target = tmp.next;
        tmp.next = target.next;
        E elem = target.getData();
        target.data = null;
        size--;
        return elem;
    }

    public void traverse() {
        Node<E> tmp = head.next;
        for (int i = 0; i < size; i++, tmp = tmp.next)
            System.out.print(tmp.getData() + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList<Integer> list1 = new LinkList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(2, 6);
        list1.remove();
        list1.remove(1);
        list1.traverse();
    }

}
