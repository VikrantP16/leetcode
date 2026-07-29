class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int[] half = new int[26];
        char middle = '\0';
        int halfLen = 0;
        for (int c = 0; c < 26; c++) {
            half[c] = freq[c] / 2;
            halfLen += half[c];
            if (freq[c] % 2 == 1) middle = (char) ('a' + c);
        }

        long total = countPermutations(half, halfLen, k);
        if (total < k) return "";

        StringBuilder result = new StringBuilder();
        int remaining = halfLen;

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long cnt = countPermutations(half, remaining - 1, k);

                if (cnt >= k) {
                    result.append((char) ('a' + c));
                    remaining--;
                    break;
                } else {
                    k -= cnt;
                    half[c]++; // revert, try next letter
                }
            }
        }

        StringBuilder answer = new StringBuilder(result);
        if (middle != '\0') answer.append(middle);
        answer.append(result.reverse());

        return answer.toString();
    }

    // Number of distinct permutations of the multiset described by counts[],
    // saturating at cap (returns cap+1 if the true value would exceed cap).
    private long countPermutations(int[] counts, int totalLen, long cap) {
        long result = 1;
        long remaining = totalLen;

        for (int c = 0; c < 26; c++) {
            if (counts[c] == 0) continue;
            long binom = binomialCapped(remaining, counts[c], cap);
            result *= binom;
            if (result > cap) return cap + 1;
            remaining -= counts[c];
        }

        return result;
    }

    // C(n, r), saturating at cap
    private long binomialCapped(long n, long r, long cap) {
        if (r == 0 || r == n) return 1;
        r = Math.min(r, n - r);

        long result = 1;
        for (long i = 1; i <= r; i++) {
            result = result * (n - r + i) / i;
            if (result > cap) return cap + 1;
        }
        return result;
    }
}