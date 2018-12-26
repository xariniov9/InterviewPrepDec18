package datastructures;

public class Stack0 {

	private int [] stkArr;
	private int top;
	
	public Stack0(int size) {
		stkArr = new int[size];
		top = -1;
	}
	
	public void push(int data) {
		if(top >= stkArr.length - 1) {
			System.out.println("Error! stack overflow");
			return;
		}
		stkArr[++top] = data;
	}
	
	public int pop() {
		if(top < 0) {
			System.out.println("error! stack underflow!");
			return 0;
		}
		
		return stkArr[top--];
	}

	public int top() {
		if(top < 0) {
			System.out.println("error! stack underflow!");
			return 0;
		}		
		return stkArr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
}
