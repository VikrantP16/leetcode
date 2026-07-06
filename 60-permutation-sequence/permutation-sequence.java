class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }
        
        // Convert k to 0-indexed
        k--;
        
        StringBuilder result = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / factorial[i - 1];
            k %= factorial[i - 1];
            result.append(numbers.remove(index));
        }
        
        return result.toString();
    }
}