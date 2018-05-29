package ch3;

/**
 * @author xiaoq
 * @date 18-5-21
 */
public class LinearProbingHashST<K, V> {
    /**
     * @parm N: the total number of key-value pairs
     * @parm M: the size of hash table;
     */
    private int N;
    private int M;
    private K[] keys;
    private V[] vals;

    public LinearProbingHashST(int _M) {
        M = _M;
        N = 0;
        keys = (K[]) new Object[M];
        vals = (V[]) new Object[M];
    }

    public LinearProbingHashST() {
        this(11);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        LinearProbingHashST<K, V> t;
        t = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        vals = t.vals;
        keys = t.keys;
        M = t.M;
    }

    public void put(K key, V val) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public V get(K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(K key) {
        if (get(key) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(K key) {
        if (contains(key)) {
            int i = hash(key);
            while (!key.equals(keys[i])) {
                i = (i + 1) % M;
            }
            keys[i] = null;
            vals[i] = null;
            i = (i + 1) % M;
            while (keys[i] != null) {
                K keyToRedo = keys[i];
                V valToRedo = vals[i];
                keys[i] = null;
                vals[i] = null;
                N--;
                put(keyToRedo, valToRedo);
                i = (i + 1) % M;
            }
            N--;
            if (N > 0 && N == M / 8) {
                resize(M / 2);
            }
        }
    }
}
