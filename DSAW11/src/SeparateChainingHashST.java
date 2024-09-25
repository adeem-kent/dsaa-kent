public class SeparateChainingHashST<Key, Value> {
    // Number of chains (buckets) for the hash table
    private int M = 97;
    // Array of chains (linked lists) where each index holds the head of the list
    private Node[] st = new Node[M];

    // Node class for the linked list (each node stores a key-value pair)
    private static class Node {
        private Object key;  // The key of the entry
        private Object val;  // The value of the entry
        private Node next;   // Pointer to the next node in the linked list

        // Constructor for the Node class
        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // Hash function to compute the index for a given key
    // It ensures the result is a valid index between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    // Insert a key-value pair into the hash table
    // If the key already exists, update its value
    public void put(Key key, Value val) {
        int i = hash(key); // Compute the hash index
        // Traverse the linked list at index i to check if the key exists
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) { // If the key is found, update its value
                x.val = val;
                return;
            }
        }
        // If the key doesn't exist, insert a new node at the front of the linked list
        st[i] = new Node(key, val, st[i]);
    }

    // Retrieve the value associated with the given key
    public Value get(Key key) {
        int i = hash(key); // Compute the hash index
        // Traverse the linked list at index i to search for the key
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val; // Return the value if the key is found
            }
        }
        return null; // Return null if the key is not found
    }

    // Delete a key-value pair from the hash table
    public void delete(Key key) {
        int i = hash(key); // Compute the hash index
        Node prev = null;
        // Traverse the linked list at index i to search for the key
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) { // If the key is found
                if (prev != null) {
                    prev.next = x.next; // Bypass the current node (deleting it)
                } else {
                    st[i] = x.next; // If the key is at the head, update the head
                }
                return;
            }
            prev = x; // Track the previous node in the list
        }
    }

    // Method to display the contents of the hash table (for testing purposes)
    public void display() {
        // Iterate through each bucket in the hash table
        for (int i = 0; i < M; i++) {
            System.out.print(i + ": ");
            // Traverse the linked list at each index and print the key-value pairs
            for (Node x = st[i]; x != null; x = x.next) {
                System.out.print(" -> " + x.key + ":" + x.val);
            }
            System.out.println(); // Move to the next line for the next bucket
        }
    }

    // Main method to test the SeparateChainingHashST class
    public static void main(String[] args) {
        // Create a new SeparateChainingHashST object with String keys and Integer values
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();

        // Insert some key-value pairs into the hash table
        st.put("apple", 1);
        st.put("banana", 2);
        st.put("orange", 3);
        st.put("grape", 4);
        st.put("melon", 5);

        // Display the hash table contents
        System.out.println("Initial Hash Table:");
        st.display();

        // Retrieve and display values associated with specific keys
        System.out.println("\nValue for 'banana': " + st.get("banana"));
        System.out.println("Value for 'grape': " + st.get("grape"));

        // Update the value for an existing key ('banana')
        st.put("banana", 20);
        System.out.println("\nUpdated value for 'banana': " + st.get("banana"));

        // Delete the key-value pair for 'orange'
        st.delete("orange");
        System.out.println("\nHash Table after deleting 'orange':");
        st.display();
    }
}
