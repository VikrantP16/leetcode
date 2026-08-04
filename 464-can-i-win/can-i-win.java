import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;

        return canWin(0, desiredTotal, maxChoosableInteger);
    }

    private boolean canWin(int usedMask, int remaining, int maxChoosableInteger) {
        if (memo.containsKey(usedMask)) {
            return memo.get(usedMask);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int bit = 1 << (i - 1);
            if ((usedMask & bit) == 0) {
                if (i >= remaining || !canWin(usedMask | bit, remaining - i, maxChoosableInteger)) {
                    memo.put(usedMask, true);
                    return true;
                }
            }
        }

        memo.put(usedMask, false);
        return false;
    }
}