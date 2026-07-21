class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int activeCount = 0;
        int bestMerge = 0;
        int prevZeroRun = Integer.MIN_VALUE;

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int runLength = j - i;

            if (s.charAt(i) == '1') {
                activeCount += runLength;
            } else {
                bestMerge = Math.max(bestMerge, prevZeroRun + runLength);
                prevZeroRun = runLength;
            }

            i = j;
        }

        return activeCount + bestMerge;
    }
}