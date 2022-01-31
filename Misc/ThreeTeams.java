package misc;

/** CN IN FOLDER */
public class ThreeTeams {
    public static void main(String[] args) {
        int input[] = { 1, 2, 1, 2, 6, 7, 5, 1 };
        System.out.println(maxCumulativeSum(input, 2));
    }

    static int maxCumulativeSum(int input[], int k) {
        int windowsSize = k * 3;
        int maxSum = 0;
        int currentMax = 0;
        for (int i = 0; i < input.length; i++) {
            currentMax = currentMax + input[i];
            if (i >= windowsSize) {
                currentMax -= input[i - windowsSize];
            }
            if (i >= windowsSize - 1) {
                maxSum = Math.max(maxSum, currentMax);
            }
        }
        return maxSum;
    }
}
