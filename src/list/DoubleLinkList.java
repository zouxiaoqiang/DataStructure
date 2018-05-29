package list;

/**
 * @author xiaoq
 */
public class DoubleLinkList<E> implements List<E> {
    private class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node() {
            this(null);
        }

        public Node(E data) {
            this.data = data;
            prev = next = null;
        }

        public E getData() {
            return data;
        }
    }

/**
* first 不存储元素 指向首元素 last是尾元素
*/

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public DoubleLinkList() {
        first = new Node<>();
        last = new Node<>();
        first = last;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public int length() {
        return size;
    }

    public Node<E> getData(int index) {
        if (index < 1 || index > size) {
            System.out.println("Invalid index");
            return null;
        }
        if (index << 1 < size) {
            return getFromFirst(index);
        } else {
            return getFromLast(index);
        }
    }

    @Override
    public E get(int index) {
        return getData(index).getData();
    }

    @Override
    public void set(int index, E elem) {
        Node<E> tmp = getData(index);
        tmp.data = elem;
    }

    private Node<E> getFromFirst(int index) {
        Node<E> tmp = first.next;
        while (index > 1) {
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }

    private Node<E> getFromLast(int index) {
        Node<E> tmp = last;
        while (index < size) {
            tmp = tmp.prev;
            index++;
        }
        return tmp;
    }

    @Override
    public int locate(E elem) {
        Node<E> tmp = first;
        for (int i = 0; i < size; i++) {
            tmp = tmp.next;
            if (tmp.getData().equals(elem)) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override
    public void add(E elem) {
        Node<E> newNode = new Node<>(elem);
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        size++;
    }

    @Override
    public void add(int index, E elem) {
        if (index == size + 1) {
            add(elem);
        }
        Node<E> tmp = getData(index);
        Node<E> newNode = new Node<>(elem);
        tmp.prev.next = newNode;
        newNode.prev = tmp.next;
        newNode.next = tmp;
        tmp.prev = newNode;
        size++;
    }

    @Override
    public E remove() {
        E elem = last.getData();
        last.data = null;
        last = last.prev;
        last.next = null;
        size--;
        return elem;
    }

    @Override
    public E remove(int index) {
        if (index == size) {
            return remove();
        }
        Node<E> tmp = getData(index);
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
        E elem = tmp.data;
        tmp.data = null;
        size--;
        return elem;
    }

    @Override
    public void traverse() {
        Node<E> tmp = first.next;
        for (int i = 0; i < size; i++, tmp = tmp.next) {
            System.out.print(tmp.getData() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkList<Integer> list = new DoubleLinkList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2, 4);
        list.add(5);
        list.remove(1);
        list.remove();
        list.add(6);
        list.remove(3);
        list.traverse();
    }

}
