package datastructures;

public class Stack<T> {
	private NodeLL<T> head;

	public Stack() {
		head = null;
	}

	public void push(T data) {
		if (head == null) {
			head = new NodeLL<T>(data);
			return;
		}
		NodeLL<T> newHead = new NodeLL<T>(data);
		newHead.next = head;
		head = newHead;
	}

	public T pop() {
		if (head != null) {
			T data = head.data;
			head = head.next;
			return data;
		}
		// TO DO : Throw exception
		System.out.println("error stack underflow!");

		return null;
	}

	public T top() {
		if (head != null) {
			return head.data;
		}
		// TO DO : Throw exception
		return null;
	}

	public boolean isEmpty() {
		return head == null;
	}
}
