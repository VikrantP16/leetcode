class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        // dp[g1][g2]: g1/g2 = 0 means that subsequence is still empty
        long[][] dp = new long[maxVal + 1][maxVal + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] newDp = new long[maxVal + 1][maxVal + 1];
            // start as "skip x" case
            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    newDp[g1][g2] = dp[g1][g2];
                }
            }

            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    long val = dp[g1][g2];
                    if (val == 0) continue;

                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);

                    // add x to seq1
                    newDp[ng1][g2] = (newDp[ng1][g2] + val) % MOD;
                    // add x to seq2
                    newDp[g1][ng2] = (newDp[g1][ng2] + val) % MOD;
                }
            }

            dp = newDp;
        }

        long ans = 0;
        for (int g = 1; g <= maxVal; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}