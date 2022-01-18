package OOPS.polynomials;

import OOPS.dynamic_arrays.DynamicArray;

public class Polynomial {
    private DynamicArray degree;

    public Polynomial() {
        degree = new DynamicArray();
    }

    public void setCoefficient(int degree, int coeff) {
        this.degree.set(degree, coeff);
    }

    public void print() {
        for (int i = 0; i < degree.dataLen(); i++) {
            if (i == 0 && degree.get(i) != 0) {
                System.out.print(degree.get(i) + " + ");
            }
            if (degree.get(i) != 0)
                System.out.print(degree.get(i) + "x^" + (i) + " +");
        }
    }

    public int get(int index) {
        if (index >= this.degree.dataLen()) {
            throw new IndexOutOfBoundsException("index greater than dynamic array len");
        } else {
            return this.degree.get(index);
        }
    }

    public void add(Polynomial p2) {
        int min = Math.min(this.degree.dataLen(), p2.degree.dataLen());
        DynamicArray temp = new DynamicArray();
        for (int i = 0; i < min; i++) {
            temp.set(i, this.get(i) + p2.get(i));
        }
        if (this.degree.dataLen() < p2.degree.dataLen()) {
            for (int i = min; i < p2.degree.dataLen(); i++) {
                temp.set(i, p2.get(i));
            }
        } else if (this.degree.dataLen() > p2.degree.dataLen()) {
            for (int i = min; i < this.degree.dataLen(); i++) {
                temp.set(i, this.get(i));
            }
        }
        this.degree = temp;
    }

    public void multiply(Polynomial p2) {
        DynamicArray temp = new DynamicArray();
        for (int i = 0; i < this.degree.dataLen(); i++) {
            for (int j = 0; j < p2.degree.dataLen(); j++) {
                // if (temp.get(i) == 0 || p2.get(j) == 0) {
                // continue;
                // }
                if (i + j >= temp.dataLen()) {
                    temp.set(i + j, 0);
                }
                temp.set(i + j, temp.get(i + j) + (p2.get(j) * get(i)));
            }
        }
        this.degree = temp;
    }

    public static void main(String[] args) {
        Polynomial test = new Polynomial();
        test.setCoefficient(5, 10);
        test.setCoefficient(2, 2);
        test.print();
        System.out.println();
        Polynomial p2 = new Polynomial();
        p2.setCoefficient(3, 4);
        p2.setCoefficient(2, 2);
        p2.print();
        System.out.println();
        test.multiply(p2);
        test.print();

        // test.degree.print();
    }
}
