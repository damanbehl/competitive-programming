package Strings;

import java.util.Stack;

public class ReverseEachWord {
    public static void main(String[] args) {
        System.out.println(
                reverseWord("Welcome to Coding Ninjas", new Stack<Character>(), "", 0));
    }

    public static String reverseWord(String input, Stack<Character> st, String result, int la) {
        if (input.length() == la) {
            result = result + " ";
            while (st.size() > 0) {
                result = result + st.pop();
            }
            return result;
        }
        if (input.charAt(la) == ' ') {
            result = result + " ";
            while (st.size() > 0) {
                result = result + st.pop();
            }
            return reverseWord(input, st, result, ++la);
        }
        st.add(input.charAt(la));
        return reverseWord(input, st, result, ++la);
    }
}