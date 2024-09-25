public class LinearProbingHashST<Key, Value> {
	private int M = 30001; // Large prime number for the size of the hash table
	private Value[] vals = (Value[]) new Object[M]; // Array to store values
	private Key[] keys = (Key[]) new Object[M]; // Array to store keys

	// Hash function: Computes the index for a given key
	private int hash(Key key) {
		// Apply bitmask 0x7fffffff to make sure the hash is positive, and then mod by M
		// (table size)
		return (key.hashCode() & 0x7fffffff) % M;
	}

	// Method to insert a key-value pair into the hash table
	public void put(Key key, Value val) {
		int i;
		// Linear probing: Iterate until we find an empty slot or a matching key
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				break; // If key already exists, break and overwrite the value
			}
		}
		keys[i] = key; // Place the key in the found slot
		vals[i] = val; // Associate the value with the key
	}

	// Method to retrieve the value associated with a key
	public Value get(Key key) {
		// Start at the hash index, and probe linearly until we find the key or an empty
		// slot
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				return vals[i]; // If the key matches, return the corresponding value
			}
		}
		return null; // If key is not found, return null
	}

	// Method to check if a given key exists in the hash table
	public boolean contains(Key key) {
		return get(key) != null; // If get() returns a value, the key exists; otherwise, it doesn't
	}

	// Method to delete a key-value pair from the hash table
	public void delete(Key key) {
		// If the key is not in the hash table, do nothing
		if (!contains(key))
			return;

		// Find the index where the key is stored
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i + 1) % M;
		}

		// Set the key and value at that index to null (mark as deleted)
		keys[i] = null;
		vals[i] = null;

		// Rehash all the keys that follow the deleted key to maintain proper clustering
		i = (i + 1) % M;
		while (keys[i] != null) {
			Key rehashKey = keys[i]; // Store the key temporarily
			Value rehashVal = vals[i]; // Store the value temporarily
			keys[i] = null; // Delete the current key-value pair
			vals[i] = null;
			put(rehashKey, rehashVal); // Reinsert the key-value pair into the hash table
			i = (i + 1) % M;
		}
	}

	// Method to display the contents of the hash table
	public void display() {
		System.out.println("Hash Table Contents:");
		for (int i = 0; i < M; i++) {
			// Print the key-value pair only if the slot is not empty
			if (keys[i] != null) {
				System.out.println("Key: " + keys[i] + ", Value: " + vals[i]);
			}
		}
	}

	// Main method to test the LinearProbingHashST class
	public static void main(String[] args) {
		// Create a new LinearProbingHashST object with String keys and Integer values
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();

		// Insert some key-value pairs
		st.put("apple", 1);
		st.put("banana", 2);
		st.put("orange", 3);
		st.put("grape", 4);
		st.put("melon", 5);

		// Display the hash table's contents after inserting
		st.display();

		// Retrieve and display a value for a specific key
		System.out.println("\nValue for 'banana': " + st.get("banana"));

		// Update the value for an existing key
		st.put("banana", 20);
		System.out.println("Updated value for 'banana': " + st.get("banana"));

		// Delete a key-value pair from the hash table
		st.delete("orange");
		System.out.println("\nAfter deleting 'orange':");
		st.display();
	}
}


//Why rehash after deletion?
//In a linear probing hash table, collisions are resolved by placing keys in the next available slot when the intended slot (computed by the hash function) is already occupied. This creates a cluster of keys that may not reside in their original hash slot but are placed in the next free spot.
//When you delete a key from such a hash table, you leave a gap in this cluster. Without rehashing the keys that follow the deleted key, future get() or put() operations might incorrectly assume that the key is not in the table when they encounter the empty slot. This would break the clustering mechanism.

//What does rehashing do?
//When you delete a key, the next few keys (if any) that followed in the same cluster need to be reinserted into the table, even though they were already in the correct position previously. This step is necessary to maintain the integrity of the table after a deletion. It ensures that all the keys are properly hashed and placed in the correct spots to ensure future lookups are accurate.