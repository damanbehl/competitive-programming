package queues.concept;

import exception.QueueEmptyException;
import linked_list.concept.Node;

public class QueueUsingLL<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public QueueUsingLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public T front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return head.data;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);
        if (size == 0) {
            head = newNode;
            tail = head;
            size++;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        size++;
    }

    public T dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        T temp = head.data;
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
        return temp;
    }
}
