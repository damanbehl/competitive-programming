package queues.concept;

import exception.QueueEmptyException;
import exception.QueueOverflowException;

public class QueueUse {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        for (int i = 1; i <= 5; i++) {
            try {
                queue.enqueue(i);
            } catch (QueueOverflowException e) {
                e.printStackTrace();
            }
        }
        while (!queue.empty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}
