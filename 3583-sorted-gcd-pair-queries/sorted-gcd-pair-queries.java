import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        int[] cnt = new int[maxVal + 1];
        for (int x : nums) cnt[x]++;

        // multiple[d] = count of elements in nums divisible by d
        int[] multiple = new int[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            int sum = 0;
            for (int m = d; m <= maxVal; m += d) {
                sum += cnt[m];
            }
            multiple[d] = sum;
        }

        // exact[d] = number of pairs whose gcd is exactly d
        long[] exact = new long[maxVal + 1];
        for (int d = maxVal; d >= 1; d--) {
            long total = (long) multiple[d] * (multiple[d] - 1) / 2;
            for (int m = 2 * d; m <= maxVal; m += d) {
                total -= exact[m];
            }
            exact[d] = total;
        }

        // prefix[d] = number of pairs with gcd <= d
        long[] prefix = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            prefix[d] = prefix[d - 1] + exact[d];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            // find smallest d such that prefix[d] > q
            int lo = 1, hi = maxVal;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] > q) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            answer[i] = lo;
        }

        return answer;
    }
}