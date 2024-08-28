public class LinkedQueueOfStrings {
	private Node first, last;

	private class Node {

		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(String item) {
		if (isEmpty())
		{
			Node n = new Node();
			n.item = item;
			first = n;
			last = n;
		}
		else
		{
			Node n = new Node (); //1
			n.item = item;
			last.next = n; // 2
			last = n; // 3
		}
		
//		Node oldlast = last;
//		last = new Node();
//		last.item = item;
//		last.next = null;
//		if (isEmpty())
//			first = last;
//		else
//			oldlast.next = last;
	}

	public String dequeue() { // same as stack pop
		String item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		return item;
	}
	
	public void printQueue() {
        Node current = first;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}
