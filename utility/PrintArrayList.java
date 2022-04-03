package utility;

import java.util.ArrayList;

public class PrintArrayList {
    public <T> void print(ArrayList<T> toPrint) {
        for (T x : toPrint) {
            System.out.print(x + " ");
        }
    }

    public <T> void printNested(ArrayList<ArrayList<T>> toPrint) {
        for (ArrayList<T> x : toPrint) {
            System.out.println();
            print(x);
        }
    }
}
