package ch2;

/**
 * @author xiaoq
 * @date 18-4-27
 */
public class Selection {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            int min = i;
            for (int j = i + 1; j < n; ++j) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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

class SelectionTest {

    public static void main(String[] args) {
        Integer[] a = {4, 1, 8, 1, 0, 10, 7, 5};
        Selection.sort(a);
        System.out.println(Selection.isSorted(a));
    }

}
