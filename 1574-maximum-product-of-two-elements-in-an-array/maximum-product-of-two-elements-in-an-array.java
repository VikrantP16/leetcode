class Solution {
    public int maxProduct(int[] nums) {
        int first = 0, second = 0; // track the two largest values seen

        for (int x : nums) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
        }

        return (first - 1) * (second - 1);
    }
}