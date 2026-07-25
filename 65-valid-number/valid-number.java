class Solution {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();

        // optional leading sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean sawDigits = false;
        boolean sawDot = false;

        // integer/decimal part
        while (i < n && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            if (s.charAt(i) == '.') {
                if (sawDot) return false; // more than one '.'
                sawDot = true;
            } else {
                sawDigits = true;
            }
            i++;
        }

        if (!sawDigits) return false; // need at least one digit before any exponent

        // optional exponent part
        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            sawDigits = false; // reset: need at least one digit after 'e'

            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }

            while (i < n && Character.isDigit(s.charAt(i))) {
                sawDigits = true;
                i++;
            }

            if (!sawDigits) return false; // exponent with no digits, e.g. "1e"
        }

        return i == n && sawDigits;
    }
}