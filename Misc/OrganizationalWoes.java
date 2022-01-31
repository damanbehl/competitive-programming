package misc;

import java.util.Arrays;

public class OrganizationalWoes {
    public static void main(String[] args) {
        String input = "ceo 3 cto cfo individual_contributors 2 individual_contributors individual_contributors 1 accountant 0 0 0 1 individual_contributors 0";
        String input2 = "ceo 2 cto cfo 2 individual_contributors individual_contributors 1 individual_contributors 0 0 0";
        String input3 = "ceo 3 cto cfo individual_contributors 2 individual_contributors individual_contributors 1 accountant 0 0 0 1 individual_contributors 0";
        // System.out.println(sameLevelOrNay(input));
        System.out.println(noOfPeopleNotWorking(input3));
    }

    static boolean sameLevelOrNay(String s) {
        String rank[] = s.split(" ");
        // boolean result = true;
        int index = 0;
        int ic_start_index = -1;
        int ic_end_index = -1;
        boolean startChecking = false;
        System.out.println(Arrays.toString(rank));
        for (String x : rank) {
            if (x.length() == 1) {
                continue;
            }
            if (x.equals("individual_contributors")) {
                if (startChecking == false) {
                    if (ic_end_index != -1) {
                        System.out.println("start index" + ic_start_index + "<>>end index" + ic_end_index);
                        return false;
                    }
                    ic_start_index = index;
                }
                startChecking = true;
            } else {
                if (startChecking) {
                    ic_end_index = index - 1;
                    startChecking = false;
                }
            }
            index++;
        }
        System.out.println("start index" + ic_start_index + "<>>end index" + ic_end_index);
        return true;
    }

    static int noOfPeopleNotWorking(String s) {
        String rank[] = s.split(" ");
        int peopleNotWorking = 0;
        for (String x : rank) {
            if (x.length() == 1) {
                continue;
            }
            if (!x.equals("individual_contributors")) {
                peopleNotWorking++;
            }
        }
        return peopleNotWorking;
    }
}
