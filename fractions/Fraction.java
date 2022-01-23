package fractions;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new Error("denominator cannot be zero");
        }
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) throws ZeroDenominatorException {
        if (denominator == 0) {
            ZeroDenominatorException e = new ZeroDenominatorException();
            throw e;
        }
        this.denominator = denominator;
        simplify();
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    private void simplify() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int denominator = f2.denominator * f1.denominator;
        int numerator = (f2.numerator * f1.denominator) + (f2.denominator * f1.numerator);
        return new Fraction(numerator, denominator);
    }

    public void add(Fraction f2) {
        this.numerator = (this.numerator * f2.denominator) + (this.denominator * f2.numerator);
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }

    public void multiply(Fraction f2) {
        this.numerator *= f2.numerator;
        this.denominator *= f2.denominator;
        simplify();
    }

}
