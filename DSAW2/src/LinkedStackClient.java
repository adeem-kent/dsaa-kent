public class LinkedStackClient {
    public static void main(String[] args) {
        // Create a LinkedStackOfStrings instance
        LinkedStackOfStrings stack = new LinkedStackOfStrings();

        // Push elements onto the stack
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");

        // Display stack status
        System.out.println("Stack after pushes:");
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Push some elements again to demonstrate stack reuse
        stack.push("A");
        stack.push("B");

        // Display stack status again
        System.out.println("Stack after pushing A and B:");
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}
