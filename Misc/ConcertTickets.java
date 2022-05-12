package misc;

//https://www.codingninjas.com/codestudio/problems/concert-tickets_1496516
import java.util.ArrayList;
import java.util.Collections;

public class ConcertTickets {
    public static int upperBound(ArrayList<Integer> arr, int k) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) > k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> concertTickets(ArrayList<Integer> price, ArrayList<Integer> pay) {
        // Write your code here.
        Collections.sort(price);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < pay.size(); i++) {
            int currPay = pay.get(i);
            int upperBound = upperBound(price, currPay);
            if (upperBound == 0) {
                ans.add(-1);
            } else {
                int finalPrice = price.get(upperBound - 1);
                ans.add(finalPrice);
                price.remove(upperBound - 1);
            }
        }
        return ans;
    }
}