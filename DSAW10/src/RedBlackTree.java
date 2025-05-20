public class RedBlackTree<Key extends Comparable<Key>, Value> {

    // Color constants: RED and BLACK for the parent links
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    // Node class to represent each node of the tree
    private class Node {
        Key key;            // Key (for comparison)
        Value val;          // Value associated with the key
        Node left, right;   // Left and right subtrees
        boolean color;      // Color of the parent link (RED or BLACK)

        // Constructor to initialize the node with key, value, and color
        Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private Node root; // Root of the Red-Black Tree

    // Helper method to check if a node is red
    private boolean isRed(Node x) {
        if (x == null) return false; // Null nodes are considered black
        return x.color == RED;
    }

    // Rotate a right-leaning red link to the left
    private Node rotateLeft(Node h) {
        assert isRed(h.right);      // Ensure right child is red before rotating
        Node x = h.right;           // Take the right child as new root
        h.right = x.left;           // Move left subtree of right child to be the right subtree of the current node
        x.left = h;                 // Make current node the left child of the new root
        x.color = h.color;          // Preserve the color of the original node
        h.color = RED;              // Mark current node as red (right-leaning link)
        return x;                   // Return new root after rotation
    }

    // Rotate a left-leaning red link to the right
    private Node rotateRight(Node h) {
        assert isRed(h.left);       // Ensure left child is red before rotating
        Node x = h.left;            // Take the left child as new root
        h.left = x.right;           // Move right subtree of left child to be the left subtree of the current node
        x.right = h;                // Make current node the right child of the new root
        x.color = h.color;          // Preserve the color of the original node
        h.color = RED;              // Mark current node as red (left-leaning link)
        return x;                   // Return new root after rotation
    }

    // In Java, the assert keyword is used as a debugging tool to test assumptions in code. When you use assert, you are stating that you expect a particular condition to be true at that point in the program. If the condition is false, the program will throw an AssertionError, indicating that something unexpected has happened.
    // Flip colors to split a 4-node (both children red)
    private void flipColors(Node h) {
        assert !isRed(h);           // Current node must be black
        assert isRed(h.left);       // Left child must be red
        assert isRed(h.right);      // Right child must be red
        h.color = RED;              // Make the current node red
        h.left.color = BLACK;       // Make the children black
        h.right.color = BLACK;      // Make the children black
    }

    // Public method to insert a key-value pair into the tree
    public void put(Key key, Value val) {
        root = put(root, key, val); // Insert recursively starting from the root
        root.color = BLACK;         // Root must always be black
    }

    // Recursive insertion method
    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, RED); // Insert new node as red

        int cmp = key.compareTo(h.key); // Compare the key with current node's key
        if (cmp < 0) h.left = put(h.left, key, val);  // Insert in left subtree
        else if (cmp > 0) h.right = put(h.right, key, val); // Insert in right subtree
        else h.val = val; // If key already exists, update its value

        // Fix right-leaning red links
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);

        // Fix consecutive red links on the left
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);

        // Split 4-nodes (both children red)
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h; // Return the updated subtree root
    }

    // Public method to retrieve the value associated with a key
    public Value get(Key key) {
        Node x = root; // Start from the root
        while (x != null) {
            int cmp = key.compareTo(x.key); // Compare the key with current node's key
            if (cmp < 0) x = x.left; // Move to left subtree if key is smaller
            else if (cmp > 0) x = x.right; // Move to right subtree if key is larger
            else return x.val; // Key found, return the value
        }
        return null; // Key not found
    }

    // Check if a key exists in the tree
    public boolean contains(Key key) {
        return get(key) != null; // If get() returns null, key is not present
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null; // Tree is empty if root is null
    }

    // Calculate the height of the tree (for analysis purposes)
    public int height() {
        return height(root); // Start height calculation from the root
    }

    // Recursive helper method to calculate height
    private int height(Node x) {
        if (x == null) return -1; // Height of an empty subtree is -1
        return 1 + Math.max(height(x.left), height(x.right)); // Height of the node is 1 + max height of its subtrees
    }
}
