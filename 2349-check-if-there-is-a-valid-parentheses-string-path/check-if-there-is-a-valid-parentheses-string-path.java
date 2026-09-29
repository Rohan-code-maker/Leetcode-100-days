class Solution {
    private int m, n;
    private char[][] grid;
    private boolean[][][] visited;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1 ||
            grid[0][0] == ')' ||
            grid[m - 1][n - 1] == '(') {
            return false;
        }

        visited = new boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int balance) {
        if (visited[i][j][balance]) {
            return false;
        }
        visited[i][j][balance] = true;

        balance += grid[i][j] == '(' ? 1 : -1;

        if (balance < 0 || balance > m - i + n - j) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (i + 1 < m && dfs(i + 1, j, balance)) {
            return true;
        }

        if (j + 1 < n && dfs(i, j + 1, balance)) {
            return true;
        }

        return false;
    }
}