package priority_queue.easy;

/**
 * Problem Description: ####You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority. 
####A queue is maintained for buying the tickets and every person has attached with a priority (an integer, 1 being the lowest priority). The tickets are sold in the following manner - 
####1. The first person (pi) in the queue asked to comes out.
####2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
####3. Otherwise, give him the ticket (and don't make him stand in queue again).
#####Giving a ticket to a person takes exactly 1 minutes and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
order of element if repetition exists is taken into account
 */
import java.util.Collections;
import java.util.PriorityQueue;

public class BuyTheTicket {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 2, 2, 4 };
        // int arr[] = { 3, 9, 4, 10, 2, 6 };
        // int arr[] = { 3, 9, 4 };
        int k = 3;
        System.out.println(buyTicket(arr, k));
    }

    public static int buyTicket(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int elem = arr[k];
        int elemCount = 0;
        int dupliTurn = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                elemCount++;
                // for repetition, to get which element
                // to process if they have the same value
                if (k == i) {
                    dupliTurn = elemCount;
                }
            }
            pq.add(arr[i]);
        }
        int timeTaken = 0;
        while (!pq.isEmpty()) {
            int x = pq.remove();
            if (x == arr[k]) {
                if (elemCount > 1) {
                    dupliTurn--;
                    // counting from 1, so base case for this edge case is ==1
                    if (dupliTurn == 1) {
                        break;
                    } else {
                        timeTaken++;
                        continue;
                    }
                }
                break;
            }
            timeTaken++;
        }
        return timeTaken + 1;
    }
}
