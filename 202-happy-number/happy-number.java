class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n); // fast starts one step ahead
        
        // Loop until fast hits 1, or they meet in a cycle
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);                 // moves 1 step
            fast = getNext(getNext(fast));        // moves 2 steps
        }
        
        // If fast hit 1, it's a happy number
        return fast == 1;
    }
    
    // Helper method to calculate the sum of the squares of the digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;      // Extract the last digit
            n = n / 10;              // Remove the last digit
            totalSum += digit * digit; 
        }
        return totalSum;
    }
}