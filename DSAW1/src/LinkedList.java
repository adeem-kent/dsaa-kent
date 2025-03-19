public class LinkedList {

	private ListNode head; // first value in the list

	// post: constructs an empty list
	public LinkedList() {
		head = null;
	}

	// post: appends the given value to the end of the list
	public void add(int value) {
		if (head == null) {
			head = new ListNode(value);
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}

	public void displayAll() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// post: returns the current number of elements in the list
	public int size() {
		int count = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (head == null) {
			return "[]";
		} else {
			String result = "[" + head.data;
			ListNode current = head.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// remove from the last
	public void remove() {
		if (head == null) {
			// List is already empty, nothing to remove
			return;
		} else if (head.next == null) {
			// Only one element in the list
			head = null;
		} else {
			// More than one element in the list
			ListNode current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
		}
	}

}
