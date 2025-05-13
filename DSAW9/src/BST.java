import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	// Node class representing each node in the BST
	private class Node {
		private Key key; // The key of the node
		private Value val; // The associated value
		private Node left, right; // Left and right subtrees
		private int count; // Size of the subtree rooted at this node

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
			this.count = 1; // Initialize node count as 1 (itself)
		}
	}

	// Return the size of the BST (number of nodes)
	public int size() {
		return size(root);
	}

	// Helper method to calculate the size of the subtree rooted at node x
	private int size(Node x) {
		if (x == null)
			return 0;
		return x.count;
	}

	// Insert a key-value pair into the BST
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	// Helper method to insert key-value pair recursively
	private Node put(Node x, Key key, Value val) {
		// If node x is null, create a new node
		if (x == null)
			return new Node(key, val);

		int cmp = key.compareTo(x.key);

		// If key is smaller, go to the left subtree
		if (cmp < 0)
			x.left = put(x.left, key, val);
		// If key is larger, go to the right subtree
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		// If key already exists, update the value
		else
			x.val = val;

		// Update the count of the subtree rooted at this node
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	// Retrieve the value associated with the key
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		return null;
	}

	// Delete the minimum key and associated value
	public void deleteMin() {
		root = deleteMin(root);
	}

	// Helper method to delete the minimum node recursively
	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right); // Update count after deletion
		return x;
	}

	// Implement delete method to remove a node by key
	public void delete(Key key) {
		root = delete(root, key);
	}

	// Helper method to delete a node recursively
	private Node delete(Node x, Key key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);
		// Traverse left if key is smaller
		if (cmp < 0)
			x.left = delete(x.left, key);
		// Traverse right if key is larger
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			// Node to be deleted found

			// Case 1: No right child, return left subtree
			if (x.right == null)
				return x.left;
			// Case 2: No left child, return right subtree
			if (x.left == null)
				return x.right;

			// Case 3: Two children
			// Replace with the minimum node from the right subtree
			Node t = x;
			x = min(t.right); // Find the minimum node in the right subtree
			// Delete that minimum node i.e if we do it will connect the remaining nodes at the end together
			//it also replaces the value
			x.right = deleteMin(t.right); 
			
			x.left = t.left; // Preserve the left subtree i.e. as x is our new node so keep the left of t in x
		}

		// Update the count of the subtree rooted at this node
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	// Helper method to find the minimum node in the subtree
		private Node min(Node x) {
			if (x.left == null)
				return x;
			else
				return min(x.left); // keep going left to find the smallest key
		}

    // Iterable is a Java interface that represents a collection of elements that can be iterated (traversed) one by one using an iterator.
	// Return all keys in the BST in sorted (in-order) order
	public Iterable<Key> keys() {
	    Queue<Key> q = new LinkedList<>();  // Create an empty queue to hold keys
	    inorder(root, q);                   // Perform in-order traversal of the BST
	    return q;                           // Return the queue as an Iterable
	}

	// Helper method to perform in-order traversal
	private void inorder(Node x, Queue<Key> q) {
		if (x == null) 
	        return;                      // Base case: if node is null, stop recursion
		
	    inorder(x.left, q);               // Recursive call on the left subtree
	    q.add(x.key);                // Add the current node's key to the queue
	    inorder(x.right, q);              // Recursive call on the right subtree
	}

	
}
