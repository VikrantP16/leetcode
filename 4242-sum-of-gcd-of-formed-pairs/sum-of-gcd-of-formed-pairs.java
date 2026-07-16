import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int runningMax = 0;

        for (int i = 0; i < n; i++) {
            runningMax = Math.max(runningMax, nums[i]);
            prefixGcd[i] = gcd(nums[i], runningMax);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        // if n is odd, the middle element (left == right) is simply skipped

        return sum;
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