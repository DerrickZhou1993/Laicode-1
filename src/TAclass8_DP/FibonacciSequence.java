package TAclass8_DP;

public class FibonacciSequence {
	public int fibonacci(int n) {
		if (n <= 1) {
			return 1;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n - 1];
	}
	
	public static void main(String[] args) {
		int n = 6;
		int res = new FibonacciSequence().fibonacci(n);
		System.out.print(res);
	}
}
