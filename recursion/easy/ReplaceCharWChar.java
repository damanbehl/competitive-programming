package recursion.easy;

public class ReplaceCharWChar {
    public static void main(String[] args) {
        String input = "abacd";
        System.out.println(replaceCharacter(input, 'a', 'x'));
    }

    public static String replaceCharacter(String input, char c1, char c2) {
        return replaceCharacterHelperLoop(input, c1, c2, "");
    }

    static String replaceCharacterHelper(String input, char c1, char c2, String res) {
        if (input.length() == 0) {
            return res;
        }
        if (input.charAt(0) == c1) {
            return replaceCharacterHelper(input.substring(1), c1, c2, res += c2);
        } else {
            return replaceCharacterHelper(input.substring(1), c1, c2, res += input.charAt(0));
        }
    }

    // for submission, stack overflows for orignal assessment question
    static String replaceCharacterHelperLoop(String input, char c1, char c2, String res) {
        res = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c1) {
                res = res + c2;
            } else {
                res = res + input.charAt(i);
            }
        }
        return res;
    }

}
