package arrays;

import java.util.HashMap;
import java.util.Scanner;

public class ArrayIntersectionRepOrd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            // n size of arr 1
            // m size of arr 2
            int n = sc.nextInt();
            int arrOne[] = new int[n];
            for (int a = 0; a < n; a++) {
                arrOne[a] = sc.nextInt();
            }
            /*
             * Order of second array is not important, we just need it's frequency,
             * We will query this table to generate the intersection with
             * repetition and the order of the first array
             */
            int m = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int a = 0; a < m; a++) {
                int incoming = sc.nextInt();
                hm.put(incoming, hm.getOrDefault(incoming, 0) + 1);
            }
            // Traverse First array again since we need it's order
            for (int j : arrOne) {
                Integer checkElem = hm.get(j);
                if (checkElem != null && checkElem.intValue() > 0) {
                    System.out.print(j + " ");
                    hm.put(j, checkElem.intValue() - 1);
                }
            }
        }
    }
}
