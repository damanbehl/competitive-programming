package Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String s = "";
        try {
            File myObj = new File("E:\\Educational\\competitive_programming\\basics\\Strings\\testinputFailed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                s = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(loopPalindrome(s.toLowerCase()));

    }

    /**
     * TODO: one test case fails for recursive call
     * 
     * @param input
     * @return
     */
    static boolean checkPalindrome(String input) {
        if (input.trim().equals("")) {
            return true;
        }
        Character first = input.charAt(0);
        Character last = input.charAt(input.length() - 1);
        if (!Character.isLetterOrDigit(first)
                || !Character.isLetterOrDigit(last)) {
            if (!Character.isLetterOrDigit(first)) {
                return checkPalindrome(input.substring(1));
            }
            if (!Character.isLetterOrDigit(last)) {
                return checkPalindrome(input.substring(0, input.length() - 1));
            }
        }
        // while (!Character.isLetterOrDigit(input.charAt(0))
        // || !Character.isLetterOrDigit(input.charAt(input.length() - 1))) {
        // if (!Character.isLetterOrDigit(input.charAt(0))) {
        // input = input.substring(1);
        // }
        // if (!Character.isLetterOrDigit(input.charAt(input.length() - 1))) {
        // input = input.substring(0, input.length() - 1);
        // }
        // }
        if (input.length() <= 1) {
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return checkPalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }

    static boolean loopPalindrome(String input) {
        int low = 0;
        int high = input.length() - 1;
        while (low < high) {
            char lowChar = input.charAt(low);
            char highChar = input.charAt(high);
            if (!Character.isLetterOrDigit(lowChar)) {
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(highChar)) {
                high--;
                continue;
            }
            if (input.charAt(low) != input.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;
    }
}
