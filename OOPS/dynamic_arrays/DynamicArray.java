package OOPS.dynamic_arrays;

import java.util.Arrays;

public class DynamicArray {
    private int data[];
    private int nextIndex;

    public DynamicArray() {
        data = new int[5];
        nextIndex = 0;
    }

    public int size() {
        return nextIndex;
    }

    public int dataLen() {
        return data.length;
    }

    public int degree() {
        return nextIndex - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(int element) {
        if (nextIndex == data.length) {
            restructure(2);
        }
        data[nextIndex] = element;
        nextIndex++;
    }

    private void restructure(int factor) {
        int temp[] = data;
        data = new int[data.length * factor];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];

        }
    }

    public void set(int index, int element) {
        if (index >= data.length) {
            int factor = (int) Math.ceil(index / dataLen()) * 2;
            restructure(factor);
            data[index] = element;
            // throw new Error("have to set all elements before this index to set this
            // one");

        } else if (index < data.length) {
            data[index] = element;
        } else {
            add(element);
        }

    }

    public int removeLast() {
        if (size() == 0) {
            throw new Error("no elements present to remove");
        }
        int element = data[nextIndex - 1];
        data[nextIndex - 1] = 0;
        nextIndex--;
        return element;
    }

    public int get(int index) {
        if (index >= data.length) {
            throw new IndexOutOfBoundsException("trying to access element outside of bounds");
        } else {
            return data[index];
        }
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();
        d.add(1);
        d.add(2);
        System.out.println(d.size());

        d.set(100, 10);
        System.out.println(d.get(99));
        System.out.println(d.get(101));
    }
}
