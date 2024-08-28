public class Merge {

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     * 
     * @param a   the array to be sorted
     * @param aux an auxiliary array used for merging
     * @param lo  the lower index of the first subarray
     * @param mid the middle index separating the two subarrays
     * @param hi  the upper index of the second subarray
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // Copy the entire array 'a' into the auxiliary array 'aux'
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1; // Initialize pointers for the two subarrays

        // Merge the two subarrays back into 'a' in sorted order
        for (int k = lo; k <= hi; k++) {
            if (i > mid) // If all elements from the left subarray are merged
                a[k] = aux[j++];
            else if (j > hi) // If all elements from the right subarray are merged
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) // If the current element in the right subarray is smaller
                a[k] = aux[j++];
            else // If the current element in the left subarray is smaller
                a[k] = aux[i++];
        }
    }

    /**
     * Recursively sorts the subarray from index 'lo' to 'hi' using the merge sort algorithm.
     * 
     * @param a   the array to be sorted
     * @param aux an auxiliary array used for merging
     * @param lo  the lower index of the subarray to be sorted
     * @param hi  the upper index of the subarray to be sorted
     */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) // Base case: if the subarray has one or no elements, it's already sorted
            return;
        int mid = lo + (hi - lo) / 2; // Find the middle index to split the subarray
        sort(a, aux, lo, mid); // Recursively sort the left subarray
        sort(a, aux, mid + 1, hi); // Recursively sort the right subarray
        merge(a, aux, lo, mid, hi); // Merge the two sorted subarrays
    }
    
    /**
     * Compares two Comparable objects and returns true if the first is less than the second.
     * 
     * @param v the first object to be compared
     * @param w the second object to be compared
     * @return true if 'v' is less than 'w'; false otherwise
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Public method to initiate the merge sort on the entire array.
     * 
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // Create the auxiliary array once
        sort(a, aux, 0, a.length - 1); // Start the recursive sort process
    }
}

//auxiliary primary purpose is to facilitate the combination of two sorted subarrays back into the original array in a way that maintains order.
// division step O(log n) and merge O(n) so O(nlogn) time complexity

// space complexity -> merge O(n) and stack space O(log n) so overall O(n)

