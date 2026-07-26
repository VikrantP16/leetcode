import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int topThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int twoSmallestAndMax = nums[0] * nums[1] * nums[n - 1];

        return Math.max(topThree, twoSmallestAndMax);
    }
}