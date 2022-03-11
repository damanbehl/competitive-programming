package utility;

import java.util.ArrayList;

public class PrintArrayList<T> {
    public void print(ArrayList<T> toPrint) {
        for (T x : toPrint) {
            System.out.print(x + " ");
        }
    }
}
