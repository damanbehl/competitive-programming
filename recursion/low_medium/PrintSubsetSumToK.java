package recursion.low_medium;

//https://www.hackerearth.com/problem/algorithm/print-subset-sum-to-k/
import java.util.ArrayList;
import java.util.Collections;

class Alist implements Comparable<Alist> {
    protected ArrayList<Integer> list;

    public Alist(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public int compareTo(Alist ob) {
        return list.get(0) < ob.list.get(0) ? -1 : list.get(0) == ob.list.get(0) ? 0 : 1;
        // or depending on if ascending or descending order wanted
        // return number > f.number
    }
}

public class PrintSubsetSumToK {
    /**
     * TODO: Sort ArrayList of ArrayList of integer
     * 
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // Collections.addAll(arr, new Integer[] { 17, 18, 6, 11, 2, 4 });
        Collections.addAll(arr, new Integer[] { 17, 18, 6, 11, 2, 4 });
        findSubsetsThatSumToK(arr, arr.size() - 1, 6);
    }

    public static void findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        ArrayList<Alist> result = new ArrayList<Alist>();
        helper(arr, arr.size() - 1, k, result);
        Collections.sort(result);
        for (Alist ob : result) {
            print(ob.list);
        }
    }

    public static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> arr, int n, int k, ArrayList<Alist> result) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (n < 0) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> singleElem = new ArrayList<Integer>();
            allSubsets.add(singleElem);
        } else {
            int currentElem = arr.get(n);
            allSubsets = helper(arr, n - 1, k, result);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> x : allSubsets) {
                ArrayList<Integer> clone = new ArrayList<Integer>();
                clone.addAll(x);
                clone.add(currentElem);
                if (sum(clone) == k) {
                    // print(clone);
                    Alist elem = new Alist(clone);
                    result.add(elem);
                }
                moreSubsets.add(clone);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    static int sum(ArrayList<Integer> toSum) {
        int sum = 0;
        for (int x : toSum) {
            sum += x;
        }
        return sum;
    }

    static void print(ArrayList<Integer> al) {
        for (int x : al) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
