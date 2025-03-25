import java.util.LinkedList;
import java.util.Queue;

public class QueueClient {
    public static void main(String[] args) {
        // Create a Queue of integers using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // Display the queue
        System.out.println("Queue: " + queue);

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Dequeue an element
        System.out.println("Dequeued element: " + queue.poll());

        // Display the queue after dequeuing an element
        System.out.println("Queue after dequeue: " + queue);

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Search for an element in the queue
        boolean containsElement = queue.contains(20);
        System.out.println("Does queue contain 20? " + containsElement);
    }
}
