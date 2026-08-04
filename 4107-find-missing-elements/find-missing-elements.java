import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // 1. Find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Use a Set for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
            numSet.add(num);
        }
        
        // 2. Find missing numbers in the range [min, max]
        List<Integer> missing = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!numSet.contains(i)) {
                missing.add(i);
            }
        }
        
        return missing;
    }
}