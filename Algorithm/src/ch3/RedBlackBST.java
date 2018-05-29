package ch3;

/**
 * @author xiaoq
 * @date 18-5-10
 */
public class RedBlackBST<K extends Comparable<K>, V> {
    public static void main(String[] args) {
        RedBlackBST<Integer, String> bst = new RedBlackBST<>();
        bst.put(3, "Jack");
        bst.put(1, "Amy");
        bst.put(8, "Leonard");
        bst.put(5, "Sheldon");
        bst.put(6, "Lily");
        bst.put(7, "Bob");
        bst.put(2, "Susan");
        bst.inOrderTraversal();
        System.out.println();
        bst.delete(3);
        bst.inOrderTraversal();
        System.out.println();
        System.out.println(bst.root.key);
        System.out.println(bst.root.left.key);
        System.out.println(bst.root.left.color);
    }

    private final boolean RED = true;
    private final boolean BLACK = false;
    public Node root;

    private class Node {
        /**
         * @parm n: the total node's number of the subtree rooted at this node
         * @parm color: the color of the link it's parent node refer
         */
        K key;
        V val;
        Node left, right;
        int n;
        boolean color;

        Node(K _key, V _val, int _n, boolean _color) {
            key = _key;
            val = _val;
            n = _n;
            color = _color;
        }

        @Override
        public String toString() {
            return key + " ";
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        } else {
            return x.color;
        }
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors1(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    private void flipColors2(Node h) {
        h.left.color = RED;
        h.right.color = RED;
        h.color = BLACK;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node h) {
        if (h != null) {
            inOrderTraversal(h.left);
            System.out.print(h.toString());
            inOrderTraversal(h.right);
        }
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node h) {
        if (h.left == null) {
            return h;
        } else {
            return min(h.left);
        }
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node h) {
        if (h.right == null) {
            return h;
        } else {
            return max(h.right);
        }
    }

    /**
     * search node by key and return it's value
     */
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node h, K key) {
        if (h == null) {
            throw new NullPointerException("get failed");
        } else {
            int cmp = key.compareTo(h.key);
            if (cmp < 0) {
                return get(h.left, key);
            } else if (cmp > 0) {
                return get(h.right, key);
            } else {
                return h.val;
            }
        }
    }

    /**
     * insert this node into tree
     * if the key exsist, update the node's value
     */
    public void put(K key, V val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, K key, V val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        } else {
            int cmp = key.compareTo(h.key);
            if (cmp < 0) {
                h.left = put(h.left, key, val);
            } else if (cmp > 0) {
                h.right = put(h.right, key, val);
            } else {
                h.val = val;
            }
            if (isRed(h.right) && !isRed(h.left)) {
                h = rotateLeft(h);
            }
            if (isRed(h.left) && isRed(h.left.left)) {
                h = rotateRight(h);
            }
            if (isRed(h.left) && isRed(h.right)) {
                flipColors1(h);
            }
            h.n = size(h.left) + size(h.right) + 1;
            return h;
        }
    }

    private Node moveRedLeft(Node h) {
        flipColors2(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if(isRed(h.right)) {
            h=  rotateLeft(h);
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors1(h);
        }
        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        } else {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = deleteMin(h.left);
            return balance(h);
        }
    }

    private Node moveRedRight(Node h) {
        flipColors2(h);
        if (!isRed(h.left.left)) {
            h = rotateRight(h);
        }
        return h;
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMax(root);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }
        if (h.right == null) {
            return null;
        } else {
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            h.right = deleteMax(h.right);
            return balance(h);
        }
    }

    public void delete(K key) {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node delete(Node h, K key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && h.right == null) {
                return null;
            }
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0) {
                h.key = min(h.right).key;
                h.val = get(h.right, h.key);
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

}
