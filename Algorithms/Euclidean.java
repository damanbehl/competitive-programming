package Algorithms;
public class Euclidean {
	static int x = 0;

	static int gcd(int a, int b) {
		System.out.println("pass>" + x + " a>" + a + " b>" + b);
		if (a == 0) {
			x++;
			return b;
		}
		x++;
		return gcd(b % a, a);
	}

	public static void main(String args[]) {
		System.out.println(gcd(433, 331));
	}
}