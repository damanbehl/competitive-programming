package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        Long arr[] = new Long[] { 7L, 3L, 2L, 4L, 9L, 12L, 56L };
        ArrayList<Long> al = new ArrayList<Long>();
        Collections.addAll(al, arr);
        // sort(al, 0, al.size() - 1);
        // print(al);
        System.out.println(findMinDiff(al, 7, 3));

    }

    public static long findMinDiff(ArrayList<Long> a, long n, long m) {
        sort(a, 0, a.size() - 1);
        // your code here
        long min = Integer.MAX_VALUE;
        for (int i = 0; i <= a.size() - (int) m; i++) {
            long diff = a.get(i + ((int) m) - 1) - a.get(i);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    static void sort(List<Long> a, int l, int r) {
        if (l < r) {
            int m = l + ((r - l) / 2);
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static void merge(List<Long> a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long left[] = new long[n1];
        long right[] = new long[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = a.get(i + l);
        }
        for (int i = 0; i < n2; i++) {
            right[i] = a.get(m + i + 1);
        }
        int k = l;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a.set(k, left[i]);
                k++;
                i++;
            } else {
                a.set(k, right[j]);
                k++;
                j++;
            }
        }
        while (j < n2) {
            a.set(k, right[j]);
            k++;
            j++;
        }
        while (i < n1) {
            a.set(k, left[i]);
            k++;
            i++;
        }
    }

    static void print(List<Long> al) {
        for (long x : al) {
            System.out.print(x + " ");
        }
    }
}
