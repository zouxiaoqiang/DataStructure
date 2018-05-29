package ch2;

import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-4-28
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i - h;
                Comparable temp = a[i];
                while (j >= 0 && less(temp, a[j])) {
                    a[j + h] = a[j];
                    j -= h;
                }
                a[j + h] = temp;
            }
            h /= 3;
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

class ShellTest {
    public static void main(String[] args) {
        Integer[] a = {3, 1, 9, 10, 4, 3, 8, 0, 3, 7, 11, 5, 6, -1};
        Shell.sort(a);
        System.out.println(Shell.isSorted(a));
        System.out.println(Arrays.toString(a));
    }
}
