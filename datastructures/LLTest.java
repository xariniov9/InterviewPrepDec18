package datastructures;

import java.util.Scanner;

public class LLTest {
	public static NodeLL<Integer> takeInput(Scanner sc) {
		System.out.println("Enter number of nodes");
		int n = sc.nextInt();
		NodeLL<Integer> head = null, curr = null;
		for (int i = 0; i < n; i++) {
			int data = sc.nextInt();
			if (i == 0) {
				head = new NodeLL<Integer>(data);
				curr = head;
			} else {
				curr.next = new NodeLL<Integer>(data);
				curr = curr.next;
			}
		}
		return head;
	}

	public static void printLL(NodeLL<Integer> head) {
		if (head == null) {
			System.out.println();
			return;
		}
		System.out.print(head.data + "->");
		printLL(head.next);
	}
	
	// reverse
	// deleteith
	// insertith
	
	public static NodeLL<Integer> insertIth(NodeLL<Integer> head, int i, int val){
		if(i == 0) {
			NodeLL<Integer> newHead = new NodeLL<Integer>(val);
			newHead.next = head;
			return newHead;
		}
		NodeLL<Integer> newhead = insertIth(head.next, i-1, val);
		head.next = newhead;
		return head;
	}
	
	public static NodeLL<Integer> deleteIth(NodeLL<Integer> head, int i){
		if(i==0) {
			return head.next;
		}
		NodeLL<Integer> newhead = deleteIth(head.next, i-1);
		head.next = newhead;
		return head;
	}
	
	public static NodePair<Integer> reverseLL(NodeLL<Integer> head) {
		if(head == null || head.next == null) {
			NodePair<Integer> ans = new NodePair<>();
			ans.first = ans.last = head;
			return ans;
		}
		NodePair<Integer> smallAns = reverseLL(head.next);
		smallAns.last.next = head;
		head.next = null;
		
		NodePair<Integer> ans = new NodePair<>();
		ans.first = smallAns.first;
		ans.last = head;
		return ans;
	}
	
	public static NodeLL<Integer> reverseLList(NodeLL<Integer> head) {
		return reverseLL(head).first;
	}
	
	public static void insertAtBottom(Stack<Integer> stk, int val) {
		if(stk.isEmpty()) {
			stk.push(val);
			return;
		}
		int top = stk.pop();
		insertAtBottom(stk, val);
		stk.push(top);
	}
	
	public static void reverseStack(Stack<Integer> stk) {
		if(stk.isEmpty()) {
			return;
		}
		int top = stk.pop();
		reverseStack(stk);
		insertAtBottom(stk, top);
	}
	
	//refer sorting in previous class codes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NodeLL<Integer> head = takeInput(sc);
		printLL(head);

		head = takeInput(sc);
		printLL(head);
		
//		head = insertIth(head, 2, 10);
//		printLL(head);
//		head = deleteIth(head, 3);
//		printLL(head);
//		head = reverseLList(head);
//		printLL(head);
		
		sc.close();
	}
}
