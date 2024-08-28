import java.util.Arrays;

public class QuickMedian {

    /**
     * Partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
     * and return the index j.
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;

        // Infinite loop that will be broken when the pointers cross
        while (true) {
            // Find item on the left that is greater than or equal to the pivot
            while (less(a[++i], a[lo]))
                if (i == hi) // Stop if pointer exceeds high bound
                    break;

            // Find item on the right that is less than or equal to the pivot
            while (less(a[lo], a[--j]))
                if (j == lo) // Stop if pointer exceeds low bound
                    break;

            // If the pointers cross, break out of the loop
            if (i >= j)
                break;

            // Swap elements at i and j
            exch(a, i, j);
        }

        // Swap the pivot element with the element at j
        exch(a, lo, j);

        // Return the partitioning index
        return j;
    }

    /**
     * Helper method to compare two elements.
     * Returns true if v is less than w, false otherwise.
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Helper method to swap elements at indices i and j in the array.
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Public method to sort an array using the QuickSort algorithm.
     * This method shuffles the array to avoid worst-case performance.
     * @param a - the array to be sorted
     */
    public static void sort(Comparable[] a) {
        // Shuffle the array to ensure random order
        StdRandom.shuffle(a);
        
        // Call the recursive sort method
        sort(a, 0, a.length - 1);
    }

    /**
     * Recursive method to sort the array.
     * @param a - the array to be sorted
     * @param lo - the lower index of the subarray
     * @param hi - the higher index of the subarray
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        // Choose the median of three as the pivot
        int median = medianOf3(a, lo, lo + (hi - lo) / 2, hi);

        // Move the median to the first position (lo) as the pivot
        exch(a, lo, median);

        // Partition the array around the pivot
        int j = partition(a, lo, hi);

        // Recursively sort the left and right halves
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * Returns the index of the median of three values (lo, mid, hi).
     * This helps to select a better pivot and improve performance.
     */
    private static int medianOf3(Comparable[] a, int lo, int mid, int hi) {
        if (less(a[mid], a[lo])) exch(a, lo, mid);
        if (less(a[hi], a[lo])) exch(a, lo, hi);
        if (less(a[hi], a[mid])) exch(a, mid, hi);
        return mid; // The median is now at index `mid`
    }
}



