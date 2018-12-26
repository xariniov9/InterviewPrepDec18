package recursion;

import java.util.Scanner;

public class Class1 {
	public static void printLL(LLNode head) {
		if (head == null) {
			System.out.println();
			return;
		}
		System.out.print(head.data + "->");
		printLL(head.next);
	}
	
	public static LLNode getLinkedList() {
		Scanner sc = new Scanner(System.in);

		System.out.println("no of nodes?");
		int n = sc.nextInt();

		LLNode head = null;
		LLNode currNode = null;

		int i = 0;
		while (i < n) {
			int data = sc.nextInt();
			if (i == 0) {
				head = new LLNode(data);
				currNode = head;
			} else {
				currNode.next = new LLNode(data);
				currNode = currNode.next;
			}
			i++;
		}
		sc.close();
		return head;
	}
	
	public static LLNode getMid(LLNode node) {
		LLNode slow = node;
		LLNode fast = node;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static LLNode merge(LLNode head1, LLNode head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		
		LLNode newHead = new LLNode();
		if(head1.data <= head2.data) {
			newHead.data = head1.data;
			newHead.next = merge(head1.next, head2);
			return newHead;
		}
		newHead.data = head2.data;
		newHead.next = merge(head1, head2.next);
		return newHead;
	}
	
	public static LLNode mergeSort(LLNode list) {
		if(list == null || list.next == null) {
			return list;
		}
		
		LLNode mid = getMid(list);
		LLNode list2 = mid.next;
		mid.next = null;

		list = mergeSort(list);
		list2 = mergeSort(list2);
		
		return merge(list, list2);
	}
	
	public static String [] subseq(String str) {
		if(str.length() == 0) {
			String [] output = new String[1];
			output[0] = "";
			return output;
		}		
		
		String [] smallAns = subseq(str.substring(1));

		String [] output = new String[2 * smallAns.length];
		int it = 0;
		for(int i =0; i<smallAns.length; i++) {
			output[it++] = smallAns[i];
		}
		for(int i=0; i<smallAns.length; i++) {
			output[it++] = str.charAt(0) + smallAns[i];
		}
		return output;
	}
	
	public static boolean subsetSum(int [] arr, int idx, int sum1, int sum2) {
		if(idx == arr.length) {
			return sum1 == sum2;
		}
		return subsetSum(arr, idx+1, sum1 + arr[idx], sum2) || 
				subsetSum(arr, idx+1, sum1, sum2  + arr[idx]);
	}
	
	public static boolean subsetSum(int [] arr) {
		return subsetSum(arr, 0, 0, 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LLNode head = getLinkedList();
//		printLL(head);
//		head = mergeSort(head);
//		printLL(head);	
//		
//		String str = "abc";
//		String[] output = subseq(str);
//		for(int i=0; i<output.length; i++) {
//			System.out.println(output[i]);
//		}
		
		int [] arr = {1, 2, 4, 1, 8};
		System.out.println(subsetSum(arr));
	}
}
