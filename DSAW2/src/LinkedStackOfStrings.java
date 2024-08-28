public class LinkedStackOfStrings {

	private Node first = null;

	private class Node {

		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		if (first == null)
		{
			Node n = new Node ();
			n.item = item;
			first = n;
		}
		else
		{
			Node n = new Node (); // 1
			n.item = item;
			n.next = first; // 2
			first = n ; //3
		}
//		Node oldfirst = first;
//		first = new Node();
//		first.item = item;
//		first.next = oldfirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
}
