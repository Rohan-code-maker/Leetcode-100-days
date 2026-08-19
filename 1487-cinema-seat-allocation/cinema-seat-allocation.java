import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for each row
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Use bitmask to mark reserved seats
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        // Initially, every row can accommodate 2 families
        int answer = (n - map.size()) * 2;

        for (int mask : map.values()) {

            boolean left = (mask & (1 << 2)) == 0
                        && (mask & (1 << 3)) == 0
                        && (mask & (1 << 4)) == 0
                        && (mask & (1 << 5)) == 0;

            boolean middle = (mask & (1 << 4)) == 0
                          && (mask & (1 << 5)) == 0
                          && (mask & (1 << 6)) == 0
                          && (mask & (1 << 7)) == 0;

            boolean right = (mask & (1 << 6)) == 0
                         && (mask & (1 << 7)) == 0
                         && (mask & (1 << 8)) == 0
                         && (mask & (1 << 9)) == 0;

            if (left && right) {
                // Two families can sit in this row
                answer += 2;
            } else if (left || middle || right) {
                // Only one family can sit
                answer += 1;
            }
        }

        return answer;
    }
}