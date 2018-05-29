package ch2;

/**
 * @author xiaoq
 * @date 18-5-6
 */
public class PriorityQueue<T extends Comparable<T>> {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(10);
        q.insert(3);
        q.insert(5);
        q.insert(4);
        q.insert(1);
        q.insert(2);
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
    }

    /**
     * pq[0] not store any element
     **/
    private T[] pq;
    private int size = 0;
    private int capacity;

    public PriorityQueue(int maxN) {
        capacity = maxN;
        pq = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(T e) {
        if (size == capacity) {
            return;
        }
        pq[++size] = e;
        swim(size);
    }

    public T delMax() {
        if (size == 0) {
            return null;
        }
        T max = pq[1];
        exch(1, size--);
        pq[size + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                ++j;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

}
