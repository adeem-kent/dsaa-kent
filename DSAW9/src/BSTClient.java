import java.util.Iterator;

public class BSTClient {
    public static void main(String[] args) {
        // Create a new Binary Search Tree (BST) instance
        BST<String, Integer> bst = new BST<>();

        // Test inserting key-value pairs into the BST
        System.out.println("Inserting key-value pairs...");
        bst.put("C", 30);
        bst.put("A", 10);
        bst.put("B", 20);
        bst.put("E", 50);
        bst.put("D", 40);
        
        System.out.println("\nSize of BST: " + bst.size());
        
        // Test retrieving values by key
        System.out.println("\nRetrieving values for keys:");
        System.out.println("Value for key 'A': " + bst.get("A"));
        System.out.println("Value for key 'C': " + bst.get("C"));
        System.out.println("Value for key 'E': " + bst.get("E"));
        System.out.println("Value for key 'Z' (non-existent): " + bst.get("Z")); // Should return null
        
        // Test printing all keys in the BST (in sorted order) using a traditional for loop
        System.out.println("\nAll keys in BST (in-order traversal):");
        
        // Iterable is a Java interface that represents a collection of elements that can be iterated (traversed) one by one using an iterator.
        Iterable<String> keysIterable = bst.keys();
        Iterator<String> keysIterator = keysIterable.iterator();
        for (int i = 0; keysIterator.hasNext(); i++) {
            String key = keysIterator.next();
            System.out.println("Key " + i + ": " + key);
        }

        // Test deleting a key (key 'C') and print remaining keys
        System.out.println("\nDeleting key 'C'...");
        bst.delete("C");
        System.out.println("All keys in BST after deleting 'C':");
        keysIterable = bst.keys();
        keysIterator = keysIterable.iterator();
        for (int i = 0; keysIterator.hasNext(); i++) {
            String key = keysIterator.next();
            System.out.println("Key " + i + ": " + key);
        }

        // Test deleting the minimum key (key 'A') and print remaining keys
        System.out.println("\nDeleting the minimum key (key 'A')...");
        bst.deleteMin();
        System.out.println("All keys in BST after deleting the minimum key:");
        keysIterable = bst.keys();
        keysIterator = keysIterable.iterator();
        for (int i = 0; keysIterator.hasNext(); i++) {
            String key = keysIterator.next();
            System.out.println("Key " + i + ": " + key);
        }

        // Test retrieving the size of the BST
        System.out.println("\nSize of BST after deletions: " + bst.size());

        // Test inserting another key-value pair and printing keys again
        System.out.println("\nInserting a new key-value pair 'F', 6...");
        bst.put("F", 6);
        System.out.println("All keys in BST after inserting 'F':");
        keysIterable = bst.keys();
        keysIterator = keysIterable.iterator();
        for (int i = 0; keysIterator.hasNext(); i++) {
            String key = keysIterator.next();
            System.out.println("Key " + i + ": " + key);
        }
        
        // Final size of BST
        System.out.println("\nFinal size of BST: " + bst.size());
    }
}
