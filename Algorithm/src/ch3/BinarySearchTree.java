package ch3;

import java.util.Iterator;

/**
 * @author xiaoq
 * @date 18-5-8
 * Principle: left child is smaller than parent,
 * and right child is bigger than parent
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(1, "Tom");
        bst.put(3, "Mike");
        bst.put(5, "Amy");
        bst.put(4, "Sheldon");
        bst.put(2, "Leonard");
        bst.inOrderTraversal();
        bst.delete(3);
        bst.inOrderTraversal();
        Iterator<Integer> iter = bst.keys(2, 4).iterator();
        System.out.println("/**************/");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node lchild, rchild;
        /**
         * the total node's number of the subtree rooted at this node
         **/
        private int n;

        public Node(K _key, V _val, int _n) {
            key = _key;
            val = _val;
            n = _n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    /**
     * search node by key and return it's value
     */
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            throw new NullPointerException("node is null");
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                return get(node.lchild, key);
            } else if (cmp > 0) {
                return get(node.rchild, key);
            } else {
                return node.val;
            }
        }
    }

    /**
     * insert this node into bstree
     * if the key exsist, update the node's value
     */
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    public Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val, 1);
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.lchild = put(node.lchild, key, val);
            } else if (cmp > 0) {
                node.rchild = put(node.rchild, key, val);
            } else {
                node.val = val;
            }
            node.n = size(node.lchild) + size(node.rchild) + 1;
            return node;
        }
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.lchild == null) {
            return node;
        } else {
            return min(node.lchild);
        }
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.rchild == null) {
            return node;
        } else {
            return max(node.rchild);
        }
    }

    /**
     * find the node with max key which isn't bigger than the parameter key,
     * and return it's key
     */
    public K floor(K key) {
        Node node = floor(root, key);
        if (node == null) {
            System.out.println(key + " is minimum");
            return null;
        } else {
            return node.key;
        }
    }

    private Node floor(Node node, K key) {
        if (node == null) {
            return null;
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node;
            } else if (cmp < 0) {
                return floor(node.lchild, key);
            } else {
                Node tmp = floor(node.rchild, key);
                if (tmp == null) {
                    return node;
                } else {
                    return tmp;
                }
            }

        }
    }

    /**
     * find the node with it's key rank k and return the node's key
     */
    public K select(int k) {
        if (k < 1 || k > size()) {
            throw new NullPointerException("Invalid rank");
        }
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        int t = size(node.lchild);
        if (t > k - 1) {
            return select(node.lchild, k);
        } else if (t < k - 1) {
            return select(node.rchild, k - t - 1);
        } else {
            return node;
        }
    }

    /**
     * find the node rank by key
     */
    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node node, K key) {
        if (node == null) {
            throw new NullPointerException("key not exsist");
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                return rank(node.lchild, key);
            } else if (cmp > 0) {
                return size(node.lchild) + 1 + rank(node.rchild, key);
            } else {
                return size(node.lchild) + 1;
            }
        }
    }

    /**
     * delete the node with min key
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.lchild == null) {
            return node.rchild;
        } else {
            node.lchild = deleteMin(node.lchild);
            node.n = size(node.lchild) + size(node.rchild) + 1;
            return node;
        }
    }

    /**
     * delete the node with key
     * if this node's left child is null, use left child replacing this node.
     * if this node's right child is null, use right child replacing this node.
     * else, use it's successor node replacing this node.
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            throw new NullPointerException("Invalid key");
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.lchild = delete(node.lchild, key);
            } else if (cmp > 0) {
                node.rchild = delete(node.rchild, key);
            } else {
                if (node.lchild == null) {
                    return node.rchild;
                } else if (node.rchild == null) {
                    return node.lchild;
                } else {
                    Node tmp = node;
                    node = min(tmp.rchild);
                    node.rchild = deleteMin(tmp.rchild);
                    node.lchild = tmp.lchild;
                }
            }
            node.n = size(node.lchild) + size(node.rchild) + 1;
            return node;
        }
    }

    /**
     * get a Iterable in a key range
     */
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        ch1.Queue<K> queue = new ch1.Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, ch1.Queue<K> queue, K lo, K hi) {
        if (node != null) {
            int cmplo = lo.compareTo(node.key);
            int cmphi = hi.compareTo(node.key);
            if (cmplo < 0) {
                keys(node.lchild, queue, lo, hi);
            }
            if (cmplo <= 0 && cmphi >= 0) {
                queue.enqueue(node.key);
            }
            if (cmphi > 0) {
                keys(node.rchild, queue, lo, hi);
            }
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.lchild);
            System.out.println(node.toString());
            inOrderTraversal(node.rchild);
        }
    }
}
