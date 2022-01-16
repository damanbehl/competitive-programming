package Strings;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-occuring-character-1587115620
 */
import java.util.ArrayList;
import java.util.List;

public class HighestOccurringCharOrd {
    public static void main(String[] args) {
        System.out.println(findHighestOccuringCharacter("testsample"));
    }

    // public static char findHighestOccuringCharacter(String input) {
    // input = input.toLowerCase();
    // int tally[] = new int[26];
    // for (char c : input.toCharArray()) {
    // int ascii = (int) c;
    // tally[ascii - 97] = tally[ascii - 97] + 1;
    // }
    // int max = 0;
    // for (int x : tally) {
    // if (x > max) {
    // max = x;
    // }
    // }
    // List<Character> al = new ArrayList<>();
    // for (int x = 0; x < tally.length; x++) {
    // if (tally[x] == max) {
    // al.add((char) (x + 97));
    // }
    // }
    // int minIndex = 0;
    // for (char c : al) {
    // int cIndex = input.indexOf(c);
    // if (input.indexOf(c) < minIndex) {
    // minIndex = cIndex;
    // }
    // }
    // return input.charAt(minIndex);
    // }
    public static char findHighestOccuringCharacter(String input) {
        input = input.toLowerCase();
        int tally[] = new int[26];
        for (char c : input.toCharArray()) {
            int ascii = (int) c;
            tally[ascii - 97] = tally[ascii - 97] + 1;
        }
        int max = 0;
        for (int x : tally) {
            if (x > max) {
                max = x;
            }
        }
        // List<Character> al = new ArrayList<>();
        // for (int x = 0; x < tally.length; x++) {
        // if (tally[x] == max) {
        // al.add((char) (x + 97));
        // }
        // }
        // int minIndex = 0;
        // for (char c : al) {
        // int cIndex = input.indexOf(c);
        // if (input.indexOf(c) < minIndex) {
        // minIndex = cIndex;
        // }
        // }
        int lexiSmall = 0;
        for (int x = 0; x < tally.length; x++) {
            if (tally[x] == max) {
                lexiSmall = x;
                break;
            }
        }
        return (char) (lexiSmall + 97);
    }
}
