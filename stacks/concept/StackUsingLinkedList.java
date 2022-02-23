package stacks.concept;

import linked_list.concept.Node;
import exception.StackEmptyException;

public class StackUsingLinkedList<T> {
    private Node<T> head;
    private int size;

    public StackUsingLinkedList(Node<T> head) {
        this.head = head;
        size = 1;
    }

    public StackUsingLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // public int size() {
    // Node<T> temp = head;
    // int i = 0;
    // while (temp != null) {
    // i++;
    // temp = temp.next;
    // }
    // return i;
    // }
    public int size() {
        return size;
    }

    public T peek() throws StackEmptyException {
        if (size == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return head.data;
    }

    public void push(T elem) {
        Node<T> newHead = new Node<T>(elem);
        newHead.next = head;
        head = newHead;
        size++;
    }

    public T pop() throws StackEmptyException {
        if (size == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        T ret = head.data;
        head = head.next;
        size--;
        return ret;
    }
}
