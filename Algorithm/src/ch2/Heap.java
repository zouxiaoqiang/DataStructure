package ch2;


import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-5-6
 */
public class Heap {

    public static void main(String[] args) {
        Integer[] a = {4, 1, 9, 3, 8, 4, 2, 0, 7, 6, 5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k > 0; --k) {
            sink(a, k, n);
        }
        while (n > 1) {
            exch(a, 0, n - 1);
            sink(a, 1, --n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a[j - 1], a[j])) {
                ++j;
            }
            if (!less(a[k - 1], a[j - 1])) {
                break;
            }
            exch(a, k - 1, j - 1);
            k = j;
        }
    }

    private static boolean less(Comparable l, Comparable r) {
        return l.compareTo(r) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
