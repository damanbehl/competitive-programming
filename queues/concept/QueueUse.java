package queues.concept;

import exception.QueueEmptyException;
// import exception.QueueOverflowException;

public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException {
        // QueueUsingArray queue = new QueueUsingArray(3);
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        // for (int i = 1; i <= 15; i++) {
        // queue.enqueue(i);
        // }

        queue.enqueue(10);
        queue.enqueue(10);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        queue.enqueue(-1);
        System.out.println("size is" + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        System.out.println("came here");
        // System.out.println(queue.dequeue());
        while (!queue.empty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}
