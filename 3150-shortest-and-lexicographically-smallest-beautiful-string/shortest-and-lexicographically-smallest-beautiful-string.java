class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int[] pos = new int[n];
        int count = 0;

        // Store positions of all 1s
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pos[count++] = i;
            }
        }

        if (count < k) {
            return "";
        }

        String ans = "";

        for (int i = 0; i + k - 1 < count; i++) {

            int firstOne = pos[i];
            int lastOne = pos[i + k - 1];

            // Remove unnecessary leading zeros.
            // Start at firstOne because any leading zero
            // makes the string longer.
            int start = firstOne;

            // We can extend the right side through zeros,
            // but the shortest choice ends at lastOne.
            int end = lastOne;

            String curr = s.substring(start, end + 1);

            if (ans.equals("") ||
                curr.length() < ans.length() ||
                (curr.length() == ans.length() && curr.compareTo(ans) < 0)) {
                ans = curr;
            }
        }

        return ans;
    }
}