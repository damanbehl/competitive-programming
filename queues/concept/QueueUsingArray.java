package queues.concept;

import exception.QueueEmptyException;
import exception.QueueOverflowException;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int size;
    private int rear;

    public QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public void enqueue(int element) {
        if (size == data.length) {
            // throw new QueueOverflowException();
            resize();
        }
        if (size == 0) {
            front = 0;
        }
        size++;
        // will always remain bw 0 -> data.len-1 (circular)
        rear = (rear + 1) % data.length;
        data[rear] = element;
    }

    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front = (front + 1) % data.length;
        // front++;
        // if (front == data.length) {
        // front = 0;
        // }
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }

    private void resize() {
        int newQueue[] = new int[data.length * 2];
        int i;
        for (i = 0; i < data.length; i++) {
            newQueue[i] = data[(i + front) % data.length];
        }
        front = 0;
        rear = i - 1;
        data = newQueue;
    }
}
