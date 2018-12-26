package recursion;

public class Class2 {	
	public static void printSubsets(int [] arr, int size) {
		for(int i=0; i<(1<<size); i++) {
			for(int j=0; j<size; j++) {
				if((i & (1<<j)) != 0){
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void printSubseq(String str, String runningAns) {
		if(str.length() == 0) {
			System.out.println(runningAns);
			return;
		}
		printSubseq(str.substring(1), runningAns);
		printSubseq(str.substring(1), str.charAt(0) + runningAns);
	}
	
	// this is 0/1 knapsack. Read about greedy knapsack!
	public static int knapsack(int idx, int W, int [] wArr, int [] valArray, int n, int [][] knpsackDP) {
		if(idx == n) {
			return 0;
		}
		if(knpsackDP[idx][W] != -1) {
			return knpsackDP[idx][W];
		}
		
		int smallAnsAfterIncluding =0, smallAnsWithoutIncluding=0;
		smallAnsWithoutIncluding = knapsack(idx+1, W, wArr, valArray, n, knpsackDP);
		if(wArr[idx] <= W) {
			smallAnsAfterIncluding = valArray[idx] + knapsack(idx+1, W-wArr[idx], wArr, valArray, n, knpsackDP);
		}
		return knpsackDP[idx][W] = Math.max(smallAnsAfterIncluding, smallAnsWithoutIncluding);
	}
	
	public static int [] fibDP;
	public static int fib(int n, int m) {
		if(n<=1) {
			return 1;
		}
		if(fibDP[n] != 0) {
			return fibDP[n];
		}
		return fibDP[n] = (fib(n-1, m) % m + fib(n-2, m) %m )%m;
	}
	
	// TO DO: space complexity of fib
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int [] arr = {1, 2, 3};
		// printSubsets(arr, 3);
		
//		int val[] = {60, 100, 120}; 
//	    int wt[] = {10, 20, 30}; 
//	    int  W = 50;
//	    System.out.println(knapsack(0, W, wt, val, 3));
//		fibDP = new int[60];
//		System.out.println(fib(50, 1000000007));
		
		printSubseq("abc", "");
	}
}
