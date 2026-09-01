class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int[][] id = new int[m][n];

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        // Find starting position and give every litter
        // a unique bit number.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                } 
                else if (ch == 'L') {
                    id[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        // Initially, all litter is still uncollected.
        int startMask = totalMasks - 1;

        /*
         * visited[row][col][energy][mask]
         *
         * mask:
         * 1 = litter is still remaining
         * 0 = litter has been collected
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][totalMasks];

        /*
         * Each state contains:
         * row, column, remaining energy, mask
         */
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        queue.offer(new int[] {
                startRow,
                startCol,
                energy,
                startMask
        });

        visited[startRow][startCol][energy][startMask] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int q = 0; q < size; q++) {

                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // Cannot make another move
                if (currentEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char nextCell = classroom[nr].charAt(nc);

                    // Moving costs 1 energy.
                    int newEnergy = currentEnergy - 1;

                    // R restores energy to maximum.
                    if (nextCell == 'R') {
                        newEnergy = energy;
                    }

                    // Copy current litter mask
                    int newMask = mask;

                    // If we reach litter, mark it collected.
                    if (nextCell == 'L') {

                        int bit = id[nr][nc];

                        newMask = newMask & ~(1 << bit);
                    }

                    // Avoid revisiting the same state
                    if (visited[nr][nc][newEnergy][newMask]) {
                        continue;
                    }

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new int[] {
                            nr,
                            nc,
                            newEnergy,
                            newMask
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}