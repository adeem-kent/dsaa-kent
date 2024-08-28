public class Recursion {
	public static int sum(int n) {
		// Base case: if n is 1, the sum is 1
		if (n <= 0) {
			return 0;
		} else {
			// Recursive case: sum of n is n plus the sum of n-1
			return n + sum(n - 1);
		}
	}

	public static int factorial(int n) {
		// Base case: if n is 0, the factorial is 1
		if (n <= 0) {
			return 1;
		} else {
			// Recursive case: factorial of n is n multiplied by factorial of n-1
			return n * factorial(n - 1);
		}
	}

	public int sumFirstN(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int N = 5; // Example input
		int result = sum(N);
		System.out.println("Sum from 1 to " + N + " is: " + result);

		int fac = factorial(N);
		System.out.println("Factorial of " + N + " is: " + fac);
	}
}
