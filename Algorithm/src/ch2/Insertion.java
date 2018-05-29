package ch2;

import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-4-27
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int j = i - 1;
            Comparable temp = a[i];
            while (j >= 0 && less(temp, a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
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

    public static boolean isSorted(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}

class InsertionTest {
    public static void main(String[] args) {
        Integer[] a = {3, 1, 10, 7, 0, 4, 2, 9};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Insertion.isSorted(a));
    }
}
