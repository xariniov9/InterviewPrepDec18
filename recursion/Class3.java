package recursion;

public class Class3 {
	
	public static int[] sieve(int n) {
		int [] sieveArr = new int[n+1];
		int i, j;
		// O(n * log log n)
		for(i=2; i<=n; i++) {
			if(sieveArr[i] == 0) {
				for(j=1; j*i <=n; j++) {
					if(sieveArr[i*j] == 0)
						sieveArr[i*j] = i;
				}
			}
		}
		return sieveArr;
	}
	
	public static boolean isPrime(int n) {
		for(int i=2; i*i <= n; i++ ) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void printPerms(String str, int mask, String runningAns) {
		if(mask == (1<<str.length()) - 1) {
			System.out.println(runningAns);
			return;
		}
		for(int i=0; i<str.length(); i++) {
			if((mask & (1<<i)) == 0) {
				printPerms(str, mask | (1<<i), runningAns + str.charAt(i));
			}
		}
	}
	
	public static void main(String[] args) {
//		int count =0;
//		int n = 10000000;
//		for(int i=2; i<=n; i++) {
//			if(isPrime(i))
//				count++;
//		}
//		System.out.println(count);
		
//		int [] sieveArr = sieve(100);
//		for(int i=2; i<100; i++) {
//			System.out.println(i + " : " + sieveArr[i]);
//		}
		
		printPerms("abc", 0, "");
	}
}
