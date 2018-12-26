package datastructures;

public class StackUsingQueue <T>{

	Queue<T> q;
	Queue<T> q1;
	
	public StackUsingQueue() {
		q = new Queue<T>();
		q1 = new Queue<T>();
	}
	
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	public void push(T data) {
		q.enqueue(data);
	}
	
	public T pop () {
		T data = null;
		while(!q.isEmpty()) {
			data = q.dequeue();
			if(!q.isEmpty()) {
				q1.enqueue(data);
			}
		}
		Queue<T> tmp = q;
		q = q1;
		q1 = tmp;		
		return data;
	}
}
