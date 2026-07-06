class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Determine sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Use long to avoid overflow (e.g., Integer.MIN_VALUE)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        result.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) {
            return result.toString();
        }
        
        result.append(".");
        
        // Map remainder -> position in the string where it first appeared
        Map<Long, Integer> seen = new HashMap<>();
        
        while (remainder != 0) {
            if (seen.containsKey(remainder)) {
                int start = seen.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }
            
            seen.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }
}