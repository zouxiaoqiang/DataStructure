package ch3;

/**
 * @author xiaoq
 * @date 18-5-21
 * Based on the unordered list
 */
public class SequentialSearchST<K, V> {
    private Node first = null;

    private class Node {
        K key;
        V val;
        Node next;

        public Node(K _key, V _val, Node _next) {
            key = _key;
            val = _val;
            next = _next;
        }
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }
}
