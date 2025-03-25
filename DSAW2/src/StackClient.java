import java.util.Stack;

public class StackClient {
	public static void main(String[] args) {
		// Create a Stack of integers
		Stack<Integer> stack = new Stack<>();

		// Push elements onto the stack
		stack.push(10);
		stack.push(20);
		stack.push(30);

		// Display the stack
		System.out.println("Stack: " + stack);

		// Peek at the top element
		System.out.println("Top element: " + stack.peek());

		// Pop an element from the stack
		System.out.println("Popped element: " + stack.pop());

		// Display the stack after popping an element
		System.out.println("Stack after pop: " + stack);

		// Check if the stack is empty
		System.out.println("Is stack empty? " + stack.isEmpty());

		// Search for an element in the stack (returns the 1-based position from the
		// top)
		int position = stack.search(10);
		if (position != -1) {
			System.out.println("Element 10 is at position: " + position);
		} else {
			System.out.println("Element 10 not found in the stack.");
		}
	}
}
