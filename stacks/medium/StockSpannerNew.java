package stacks.medium;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpannerNew {
    Stack<Integer> st;
    Stack<Integer> indexSt;
    ArrayList<Integer> al;

    public StockSpannerNew() {
        st = new Stack<Integer>();
        al = new ArrayList<Integer>();
    }

    public int next(int price) {
        int alSize = al.size();
        int returnVal = 0;
        while (!st.empty() && st.peek() <= price) {
            st.pop();
            indexSt.pop();
        }
        if (st.empty()) {
            al.add(alSize + 1);
            st.push(price);
            indexSt.push(alSize);
            returnVal = alSize + 1;
        } else {
            st.push(price);
            returnVal = alSize - indexSt.peek();
            indexSt.push(alSize);
        }
        return returnVal;
    }
}
