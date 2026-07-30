class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int totalPushes = 0;

        for (int i = 0; i < n; i++) {
            int pushesForThisLetter = (i / 8) + 1;
            totalPushes += pushesForThisLetter;
        }

        return totalPushes;
    }
}