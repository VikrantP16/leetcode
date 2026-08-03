class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[n] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            int sum = 0;

            for (int take = 1; take <= 3 && i + take <= n; take++) {
                sum += stoneValue[i + take - 1];
                best = Math.max(best, sum - dp[i + take]);
            }

            dp[i] = best;
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}