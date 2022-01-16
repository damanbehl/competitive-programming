package Strings;

//https://www.codingninjas.com/codestudio/problems/compress-the-string_526

public class CompressString {
    public static void main(String[] args) {
        System.out.println(getCompressedString("aaaaaaaaa"));
    }

    public static String getCompressedString(String str) {
        if (str.length() == 0) {
            return "";
        }
        // Write your code here.
        // return recursiveCompressor(str, "", 0, 0);
        return loopCompressor(str);

    }

    // TODO:stack overflow on recursive call figure out why
    public static String recursiveCompressor(String input, String result, int reps, int pointer) {
        if (pointer == input.length() - 1) {
            if (reps == 0) {
                result += input.charAt(pointer);
                return result;
            } else {
                result = result + input.charAt(pointer) + String.valueOf(reps + 1);
                return result;
            }
        } else {
            if (input.charAt(pointer) == input.charAt(pointer + 1)) {
                return recursiveCompressor(input, result, ++reps, ++pointer);
            } else {
                if (reps == 0) {
                    result = result + input.charAt(pointer);
                } else {
                    result = result + input.charAt(pointer) + String.valueOf(reps + 1);
                }
                return recursiveCompressor(input, result, 0, ++pointer);
            }
        }

    }

    public static String loopCompressor(String input) {
        if (input.length() < 2) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                continue;
            }
            sb.append(input.charAt(i));
            if (count > 1) {
                sb.append(count);
                count = 1;
            }
        }
        return sb.toString();
    }
}
