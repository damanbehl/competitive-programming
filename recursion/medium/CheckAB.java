package recursion.medium;

public class CheckAB {
    public static void main(String[] args) {
        System.out.println(verifyIntegrity("aaaa"));
    }

    static boolean verifyIntegrity(String input) {
        if (input.charAt(0) != 'a') {
            return false;
        }
        return verifyIntegrityHelper(input, 0);
    }

    static boolean verifyIntegrityHelper(String input, int index) {
        if (index >= input.length()) {
            return true;
        }
        if (input.charAt(index) == 'a') {
            if (index + 2 < input.length()) {
                if (input.charAt(index + 1) == 'b' && input.charAt(index + 2) == 'a') {
                    return false;
                }
                return verifyIntegrityHelper(input, index + 1);
            } else {
                if (index + 1 < input.length()) {
                    if (input.charAt(index + 1) == 'b') {
                        return false;
                    }
                }
                return verifyIntegrityHelper(input, index + 1);
            }
        } else {
            if (index + 2 < input.length()) {
                if (input.charAt(index + 1) == 'a') {
                    return false;
                }
                if (input.charAt(index + 1) == 'b' && input.charAt(index + 2) == 'b') {
                    return false;
                }
                return verifyIntegrityHelper(input, index + 2);
            } else {
                if (index + 1 < input.length()) {
                    if (input.charAt(index + 1) == 'a') {
                        // never runs
                        return false;
                    }
                }
                return verifyIntegrityHelper(input, index + 1);
            }
        }
    }
}