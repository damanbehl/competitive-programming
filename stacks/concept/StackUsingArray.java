package stacks.concept;

import exception.StackEmptyException;
import exception.StackFullException;

public class StackUsingArray {
    private int[] data;
    // index of topmost element
    private int top;

    public StackUsingArray() {
        data = new int[10];
        top = -1;
    }

    public StackUsingArray(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        // if top is -1, that means no elements in stack
        return top == -1;
    }

    public int size() {
        // number of elements in stack is different
        // from capacity of stack
        return top + 1;
    }

    public int peek() throws StackEmptyException {
        if (size() == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return data[top];
    }

    // public void push(int elem) throws StackFullException {
    // if (size() == data.length) {
    // // stack full
    // StackFullException e = new StackFullException();
    // throw e;
    // }
    // top++;
    // data[top] = elem;
    // }

    public void push(int elem) {
        if (size() == data.length) {
            // stack full
            resize();
        }
        top++;
        data[top] = elem;
    }

    public int pop() throws StackEmptyException {
        if (size() == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        int ret = data[top];
        top--;
        return ret;
    }

    private void resize() {
        int newData[] = new int[2 * size()];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
