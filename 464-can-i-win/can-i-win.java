import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;

        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;

        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(0, desiredTotal, maxChoosableInteger, memo);
    }

    private boolean canWin(int usedMask, int remaining, int maxChoosableInteger, Map<Integer, Boolean> memo) {
        if (memo.containsKey(usedMask)) {
            return memo.get(usedMask);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int bit = 1 << (i - 1);
            if ((usedMask & bit) == 0) {
                if (i >= remaining || !canWin(usedMask | bit, remaining - i, maxChoosableInteger, memo)) {
                    memo.put(usedMask, true);
                    return true;
                }
            }
        }

        memo.put(usedMask, false);
        return false;
    }
}