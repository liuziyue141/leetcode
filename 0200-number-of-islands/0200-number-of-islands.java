class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0 && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
        }
    }
}