public class RedBlackTreeClient {
    public static void main(String[] args) {
        // Create an instance of the Red-Black Tree with Integer keys and String values
        RedBlackTree<Integer, String> rbt = new RedBlackTree<>();

        // Insert key-value pairs into the Red-Black Tree
        rbt.put(1, "one");
        rbt.put(2, "two");
        rbt.put(3, "three");
        rbt.put(4, "four");
        rbt.put(5, "five");

        // Retrieve and print the value associated with key 3
        System.out.println("Get value for key 3: " + rbt.get(3)); // Output: three

        // Try to retrieve a non-existing key (key 6)
        System.out.println("Get value for key 6: " + rbt.get(6)); // Output: null

        // Check if certain keys exist in the tree
        System.out.println("Tree contains key 2: " + rbt.contains(2)); // Output: true
        System.out.println("Tree contains key 6: " + rbt.contains(6)); // Output: false

        // Print the height of the tree
        System.out.println("Tree height: " + rbt.height()); // Output: Height of the tree, depends on insertion order
    }
}
