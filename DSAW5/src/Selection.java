public class Selection {
	// we are using Comparable instead of String to ensure that the objects being sorted can be compared with each other using compareTo function
	// the compare to function is built in here
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) 
		{
			int min = i;
			for (int j = i + 1; j < N; j++) 
			{
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}

//The Comparable interface in Java defines a method called compareTo, which is used to compare the current object with another object of the same type. 
//By using Comparable, you can create a generic sorting method that can sort any type of object, as long as those objects implement the Comparable interface.
