import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> present = new HashSet<>();

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            present.add(x);
        }

        List<Integer> missing = new ArrayList<>();
        for (int v = min; v <= max; v++) {
            if (!present.contains(v)) {
                missing.add(v);
            }
        }

        return missing;
    }
}