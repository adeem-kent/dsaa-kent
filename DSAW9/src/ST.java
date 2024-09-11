public class ST<Key extends Comparable<Key>, Value> {

    // Arrays to hold keys and their corresponding values
    private Key[] keys;  // Array to hold keys
    private Value[] vals; // Array to hold values
    private int N = 0;    // Number of key-value pairs currently in the table

    // Constructor to create an empty symbol table with a default initial capacity
    @SuppressWarnings("unchecked")
    public ST() {
        keys = (Key[]) new Comparable[10];  // Assuming initial size of 10 for the key array
        vals = (Value[]) new Object[10];    // Same initial size for the value array
    }

    // Method to insert a key-value pair into the symbol table
    // If the key already exists, its value is updated
    public void put(Key key, Value val) {
        int i = rank(key);  // Find the appropriate position for the key using binary search

        // If the key already exists, update the value and return
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // If the arrays are full, resize them to hold more elements
        if (N == keys.length) resize(2 * keys.length);

        // Shift all keys and values to the right to make space for the new entry
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        // Insert the new key-value pair at the correct position
        keys[i] = key;
        vals[i] = val;
        N++;  // Increment the count of key-value pairs
    }

    // Method to retrieve the value associated with a given key
    // Returns null if the key is not found
    public Value get(Key key) {
        if (isEmpty()) return null;  // If the table is empty, return null

        int i = rank(key);  // Find the position of the key using binary search

        // If the key is found, return the associated value
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];

        // If the key is not found, return null
        return null;
    }

    // Method to check if a key is in the symbol table
    public boolean contains(Key key) {
        return get(key) != null;  // If get() returns a value, the key exists; otherwise, it does not
    }

    // Method to delete a key from the symbol table by setting its value to null
    public void delete(Key key) {
        put(key, null);  // Simply set the value to null, but the key remains in the table
    }

    // Method to check if the table is empty
    public boolean isEmpty() {
        return N == 0;  // The table is empty if the number of key-value pairs is 0
    }

    // Method to get the number of key-value pairs in the symbol table
    public int size() {
        return N;
    }

    // Method to get all keys in the table as an iterable list
    @SuppressWarnings("unchecked")
    public Iterable<Key> keys() {
        Key[] result = (Key[]) new Comparable[N];  // Create a new array to hold the keys
        System.arraycopy(keys, 0, result, 0, N);   // Copy the keys from the original array
        return java.util.Arrays.asList(result);    // Return the keys as a list
    }

    // Private method to find the rank of a key using binary search
    // This returns the index where the key should be inserted or the position of the key if it exists
    private int rank(Key key) {
        int lo = 0, hi = N - 1;  // Set low and high pointers for binary search

        // Perform binary search to find the correct position for the key
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;  // Calculate the middle index
            int cmp = key.compareTo(keys[mid]);  // Compare the key with the key at the mid index
            if (cmp < 0) hi = mid - 1;  // If key is smaller, search in the left half
            else if (cmp > 0) lo = mid + 1;  // If key is larger, search in the right half
            else return mid;  // If key is found, return its position
        }
        return lo;  // If key is not found, return the index where it should be inserted
    }

    // Private method to resize the arrays when they are full
    // Doubles the capacity of the arrays
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Comparable[capacity];  // Create a new larger array for keys
        Value[] tempVals = (Value[]) new Object[capacity];  // Create a new larger array for values

        // Copy the current keys and values into the new arrays
        System.arraycopy(keys, 0, tempKeys, 0, N);
        System.arraycopy(vals, 0, tempVals, 0, N);

        // Replace the old arrays with the new ones
        keys = tempKeys;
        vals = tempVals;
    }
}
