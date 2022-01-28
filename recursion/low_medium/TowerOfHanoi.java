/**
 * https://www.codingninjas.com/codestudio/problems/tower-of-hanoi_981323
 */
package recursion.low_medium;

import java.util.ArrayList;

public class TowerOfHanoi {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = towerOfHanoi(3);
        System.out.print("{ ");
        for (ArrayList<Integer> x : al) {
            print(x);
        }
        System.out.print(" }");
    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        towerOfHanoiHelper(n, 1, 3, 2, al);
        return al;
    }

    static void towerOfHanoiHelper(int n, int from, int to, int via,
            ArrayList<ArrayList<Integer>> al) {
        if (n == 1) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(from);
            sub.add(to);
            al.add(sub);
            return;
        }
        towerOfHanoiHelper(n - 1, from, via, to, al);
        ArrayList<Integer> sub = new ArrayList<Integer>();
        sub.add(from);
        sub.add(to);
        al.add(sub);
        towerOfHanoiHelper(n - 1, via, to, from, al);

    }

    static void print(ArrayList<Integer> toPrint) {
        System.out.print("{ ");
        for (int x : toPrint) {
            System.out.print(x + ", ");
        }
        System.out.print(" },");
    }
}
