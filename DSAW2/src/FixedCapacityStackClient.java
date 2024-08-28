public class FixedCapacityStackClient {
    public static void main(String[] args) {
        // Create a FixedCapacityStackOfStrings with a capacity of 5
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);

        // Push elements onto the stack
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        // Display stack status
        System.out.println("Stack after pushes:");
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Push some elements again to demonstrate stack reuse
        stack.push("X");
        stack.push("Y");

        // Display stack status again
        System.out.println("Stack after pushing X and Y:");
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}
