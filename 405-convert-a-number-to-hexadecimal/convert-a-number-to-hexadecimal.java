class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexDigits = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Treat num as an unsigned 32-bit value by masking with a long
        long n = num & 0xFFFFFFFFL;

        while (n > 0) {
            int digit = (int) (n & 0xF); // last 4 bits
            sb.append(hexDigits[digit]);
            n >>>= 4; // unsigned right shift by 4 bits
        }

        return sb.reverse().toString();
    }
}