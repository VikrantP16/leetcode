class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        final int LIMIT = 2048; // nums[i] <= 1500 < 2^11, so any XOR result < 2048

        boolean[] pairXor = new boolean[LIMIT];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] seenVal = new boolean[1501];
        for (int v : nums) {
            seenVal[v] = true;
        }

        boolean[] tripletXor = new boolean[LIMIT];
        for (int v = 1; v <= 1500; v++) {
            if (!seenVal[v]) continue;
            for (int p = 0; p < LIMIT; p++) {
                if (pairXor[p]) {
                    tripletXor[v ^ p] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : tripletXor) {
            if (b) count++;
        }
        return count;
    }
}