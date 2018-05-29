package ch2;

import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-4-28
 */
public class Quick {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low < high) {
            int mid = partition(a, low, high);
            sort(a, low, mid - 1);
            sort(a, mid + 1, high);
        }
    }

    private static int partition(Comparable[] a, int low, int high) {
        int left = low, right = high + 1;
        Comparable temp = a[low];
        while (left < right) {
            while (less(a[++left], temp) && left != high) {
            }
            while (less(temp, a[--right])) {
            }
            if (left < right) {
                exch(a, left, right);
            }
        }
        exch(a, low, right);
        return right;
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

class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {4, 1, 9, 5, 11, 0, 3, 8, 4, 2, 9, 6};
        Quick.sort(a);
        System.out.println(Quick.isSorted(a));
        System.out.println(Arrays.toString(a));
    }
}
