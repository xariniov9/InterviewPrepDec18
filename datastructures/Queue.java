package datastructures;

public class Queue<T> {

	private DoublyLLNode<T> head, tail;

	public Queue() {
		// TODO Auto-generated constructor stub
	}

	public void enqueue(T data) {
		DoublyLLNode<T> newNode = new DoublyLLNode<T>(data);
		if (head == null) { // if Queue is empty
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;

	}

	public T dequeue() {
		if(head == null) {
			System.out.println("Error");
			return null;
		}
		T data = head.data;
		if(head == tail) {
			head = tail = null;
			return data;
		}
		head = head.next;
		head.prev =  null;
		return data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T first() {
		if(head == null) {
			System.out.println("Error");
			return null;
		}
		return head.data;
	}

}
