package datastructures;

import java.util.*;
import java.util.Queue;

public class BTTest {

	public static int height(NodeBT root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	// TODO : improve complexity
	public static int diameter(NodeBT root) {
		if(root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		
		int leftDia = diameter(root.left);
		int rightDia = diameter(root.right);
		
		int leftHeight = root.left != null ? height(root.left) + 1 : 0;
		int rightHeight = root.right != null ? height(root.right) + 1 : 0;
		
		return Math.max(leftDia, Math.max(rightDia, leftHeight + rightHeight));
	}
	
	public static void levelOrder(NodeBT root) {
		Queue<NodeBT> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			NodeBT node = q.remove();
			System.out.println(node.data);
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
	}
	
	public static void inOrder(NodeBT root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public static void postOrder(NodeBT root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
		
	}
	
	public static void main(String[] args) {
		NodeBT root = new NodeBT(0);
		root.left = new NodeBT(1);
		root.left.left = new NodeBT(2);
		root.left.right = new NodeBT(3);
		root.right = new NodeBT(10);
		root.right.left = new NodeBT(12);
		root.right.right = new NodeBT(45);
		root.right.right.left = new NodeBT(46);
		
		postOrder(root);
	}
}
