package dynamicP.medium;

import java.util.HashMap;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays ob = new DecodeWays();
        System.out.println(ob.solve("26"));
    }

    public int solve(String message) {
        int stringLength = message.length();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(stringLength, 1);
        for (int i = stringLength - 1; i >= 0; i--) {
            int putValue = 0;
            if (message.charAt(i) == '0') {
                putValue = 0;
            } else {
                putValue = hm.get(i + 1);
            }

            if ((i + 1) < stringLength && ((message.charAt(i) == '1'
                    || message.charAt(i) == '2') && (int) message.charAt(i + 1) < 7)) {
                System.out.println("char at i+1" + (int) message.charAt(i + 1));
                putValue += hm.get(i + 2);
            }
            hm.put(i, putValue);
        }
        return hm.get(0);
    }
}
