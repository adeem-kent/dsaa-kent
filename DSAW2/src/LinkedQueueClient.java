public class LinkedQueueClient {
    public static void main(String[] args) {
        // Create a LinkedQueueOfStrings instance
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();

        // Enqueue elements
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Fourth");
        
        System.out.println("Queue elements:");
        queue.printQueue(); // Should print: First Second Third Fourth 

        // Display queue status
        System.out.println("Queue after enqueues:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        // Enqueue some elements again to demonstrate queue reuse
        queue.enqueue("A");
        queue.enqueue("B");

        // Display queue status again
        System.out.println("Queue after enqueueing A and B:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }
    }
}
