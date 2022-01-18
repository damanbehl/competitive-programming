package OOPS.complex_numbers;

public class ComplexNumbers {
    private int realPart;
    private int imaginaryPart;

    public ComplexNumbers(int realPart, int imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public int getRealPart() {
        return realPart;
    }

    public void setRealPart(int realPart) {
        this.realPart = realPart;
    }

    public int getImaginaryPart() {
        return realPart;
    }

    public void setImaginaryPart(int realPart) {
        this.realPart = realPart;
    }

    public void add(ComplexNumbers c2) {
        realPart = realPart + c2.realPart;
        imaginaryPart = imaginaryPart + c2.imaginaryPart;
    }

    public void multiplyCmpNumbers(ComplexNumbers c2) {
        int newrealPart = realPart * c2.realPart - imaginaryPart * c2.imaginaryPart;
        int newimaginaryPart = realPart * c2.imaginaryPart + imaginaryPart * c2.realPart;
        realPart = newrealPart;
        imaginaryPart = newimaginaryPart;
    }

    public void conjugate() {
        imaginaryPart = imaginaryPart * -1;
    }

    public static ComplexNumbers add(ComplexNumbers c1, ComplexNumbers c2) {
        int newReal = c1.realPart + c2.realPart;
        int newImag = c1.imaginaryPart + c2.imaginaryPart;
        return new ComplexNumbers(newReal, newImag);
    }

    public void print() {
        char imgPrefix = ' ';
        if (imaginaryPart >= 0) {
            imgPrefix = '+';
        }
        String result = realPart + " " + imgPrefix + imaginaryPart + "i";
        System.out.println(result);
    }
}