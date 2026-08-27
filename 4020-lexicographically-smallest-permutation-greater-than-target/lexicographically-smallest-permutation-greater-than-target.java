class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // count = characters available after matching target
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            count[target.charAt(i) - 'a']--;
        }

        // Try changing target from right to left
        for (int i = n - 1; i >= 0; i--) {

            int current = target.charAt(i) - 'a';

            // Restore target[i]
            count[current]++;

            // Check whether target[0 ... i-1]
            // can be formed from s
            boolean possible = true;

            for (int j = 0; j < 26; j++) {
                if (count[j] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            // Find the smallest character greater than target[i]
            for (int j = current + 1; j < 26; j++) {

                if (count[j] > 0) {

                    // We found the character to put at position i
                    count[j]--;

                    StringBuilder ans = new StringBuilder();

                    // Prefix remains same as target
                    ans.append(target, 0, i);

                    // Make this position greater
                    ans.append((char) ('a' + j));

                    // Put remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}