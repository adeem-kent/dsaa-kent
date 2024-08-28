public class LinkedList {

	private ListNode first; // first value in the list

	// post: constructs an empty list
	public LinkedList() {
		first = null;
	}

	// post: appends the given value to the end of the list
	public void add(int value) {
		if (first == null) {
			first = new ListNode(value);
		} else {
			ListNode current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}

	public void displayAll() {
		ListNode current = first;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// post: returns the current number of elements in the list
	public int size() {
		int count = 0;
		ListNode current = first;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (first == null) {
			return "[]";
		} else {
			String result = "[" + first.data;
			ListNode current = first.next;
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
		if (first == null) {
			// List is already empty, nothing to remove
			return;
		} else if (first.next == null) {
			// Only one element in the list
			first = null;
		} else {
			// More than one element in the list
			ListNode current = first;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
		}
	}

}
