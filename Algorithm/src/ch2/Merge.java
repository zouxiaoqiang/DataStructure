package ch2;

import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-4-28
 */
public class Merge {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sortBU(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        if (less(a[mid + 1], a[mid])) {
            merge(a, low, mid, high);
        }
    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; ++k) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; ++k) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if(less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
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

class MergeSort {
    public static void main(String[] args) {
        Integer[] a = {6, 4, 1, 9, 10, 2, 8, 5, 0, 7, 11, 3};
        Merge.sort(a);
        System.out.println(Merge.isSorted(a));
        System.out.println(Arrays.toString(a));
    }
}

