package arrays;

import java.util.HashMap;
import java.util.Scanner;

public class FindDuplicate {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < size; j++) {
                int inputElem = sc.nextInt();
                hm.put(inputElem, hm.getOrDefault(inputElem, 0) + 1);
            }
            for (int x : hm.keySet()) {
                if (hm.get(x) != 1) {
                    System.out.println(x);
                    break;
                }
            }
        }
    }
}
