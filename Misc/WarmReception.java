package misc;

/**
 * There is only one beauty parlour in the town CodingNinjasLand.
 * The receptionist at the beauty parlor is flooded with appointment requests
 * because the “Hakori” festival is round the corner and everyone wants to look
 * good on it.
 * #### She needs your help. The problem is they don’t have chairs in reception.
 * They are ordering chairs from NinjasKart.
 * They don’t want to order more than required. You have to tell the minimum
 * number of chairs required such that none of the customers has to stand.
 * ####Sample Input 1 :
 * 5
 * 900 1000 1100 1030 1600
 * 1900 1300 1130 1130 1800
 * 
 * ####Sample Output 1:
 * 4
 * 
 * ####Explanation:
 * 4 because at 1100 hours, we will have maximum number of customers at the
 * shop, throughout the day. And that maximum number is 4.
 */

public class WarmReception {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int arrival[] = { 900, 1000, 1100, 1030, 1600 };
        int departure[] = { 1900, 1300, 1130, 1130, 1800 };
        System.out.println(orderChairs(arrival, departure));
    }

    static int orderChairs(int arrival[], int departure[]) {
        int tracker[] = new int[2360];
        for (int i = 0; i < arrival.length; i++) {
            incrementTracker(tracker, arrival[i], departure[i]);
        }
        return max;
    }

    static void incrementTracker(int tracker[], int from, int to) {
        for (int i = 0; i <= to - from; i++) {
            if (tracker[i + from] + 1 > max) {
                max = tracker[i + from] + 1;
            }
            tracker[i + from] = tracker[i + from] + 1;
        }
    }
}
