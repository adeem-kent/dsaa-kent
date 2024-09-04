public class Heap {
	// Main method to sort the array using Heap Sort
	public static void sort(Comparable[] a) {
		int N = a.length - 1; // Use N-1 for 0-indexed arrays

		// Build the max-heap by calling sink for each non-leaf node
		for (int k = N / 2; k >= 0; k--) {
			sink(a, k, N);
		}

		// Sort the array
		while (N > 0) {
			exch(a, 0, N); // Move the current largest element to the end
			sink(a, 0, --N); // Restore heap property after removal
		}
	}

	// Sink function to restore heap property for the element at index k
	private static void sink(Comparable[] a, int k, int N) {
		while (2 * k + 1 <= N) { // While k has at least one child (0-indexed)
			int j = 2 * k + 1; // Left child (0-indexed)
			if (j < N && less(a, j, j + 1)) // If right child is larger than left
				j++; // Move to the right child

			if (!less(a, k, j)) // If the current node is larger than the child, break
				break;

			exch(a, k, j); // Swap current node with the larger child
			k = j; // Move down the heap to the child's position
		}
	}

	// Helper function to compare elements in the array
	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	// Helper function to exchange two elements in the array
	private static void exch(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Main method for testing
	public static void main(String[] args) {
		Integer[] array = { 4, 10, 3, 5, 1 };
		Heap.sort(array);

		// Print the sorted array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
