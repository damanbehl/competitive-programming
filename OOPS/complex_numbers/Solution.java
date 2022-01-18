package OOPS.complex_numbers;

public class Solution {
    public static void main(String[] args) {
        ComplexNumbers c1 = new ComplexNumbers(4, 5);
        ComplexNumbers c2 = new ComplexNumbers(6, 7);
        c1.multiplyCmpNumbers(c2);
        c1.print();
        // c1.add(c2);
        // c1.print();
        // ComplexNumbers c3 = ComplexNumbers.add(c1, c2);
        // c3.print();
        // c3.conjugate();
        // c3.print();

    }
}
