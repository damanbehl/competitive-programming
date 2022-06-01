package Maths.easy;

public class SqrtPrecision {
    public static double sqrtWithPrecision(double d, double P) {
        double guess = d / 2;
        while (Math.abs((guess * guess) - d) > P) {
            guess = (guess + (d / guess)) / 2;
        }
        return guess;
    }
}
