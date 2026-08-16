class Solution {

    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        // Count numbers based on remainder % 3
        for (int stone : stones) {
            count[stone % 3]++;
        }

        int c0 = count[0];
        int c1 = count[1];
        int c2 = count[2];

        // If there are no stones with remainder 1 or 2,
        // Alice cannot make a winning move.
        if (c1 == 0 && c2 == 0) {
            return false;
        }

        // If count[0] is even, it does not affect
        // the winner significantly.
        if (c0 % 2 == 0) {
            return c1 > 0 && c2 > 0;
        }

        // count[0] is odd
        return Math.abs(c1 - c2) > 2;
    }
}