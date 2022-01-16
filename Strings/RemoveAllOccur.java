package Strings;

public class RemoveAllOccur {
    static String removeAllOccurrencesOfChar(String input, char c) {
        // Write your code here
        String result = "";
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != c) {
                result = result + input.charAt(i);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String input = "welcome to coding ninjas";
        char c = 'o';
        String ans = removeAllOccurrencesOfChar(input, c);
        System.out.println(ans);
    }
}
