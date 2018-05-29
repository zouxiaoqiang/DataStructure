package ch3;

/**
 * @author xiaoq
 * @date 18-5-21
 */
public class SeparateChainingHashST<K, V> {
    /**
     * @parm N: the total number of key-value pairs
     * @parm M: the size of hash table
     * @parm st: the array storing linked list
     */
    private int N;
    private int M;
    private SequentialSearchST<K, V>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int _M) {
        M = _M;
        st = (SequentialSearchST<K, V>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public void put(K key, V val) {
        st[hash(key)].put(key, val);
    }
}
