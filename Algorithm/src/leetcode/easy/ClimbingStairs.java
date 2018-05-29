package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-29
 */
public class ClimbingStairs {
    /**
     * Dynamic Programming:
     * case(n) = case(n-1) + case(n-2)
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(44));
    }
}
