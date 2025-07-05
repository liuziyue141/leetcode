

import static java.lang.Math.max;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int largestIsland(int[][] grid) {
        int id = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[][] islands = new int[n][m];
        List<Integer> size = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && islands[i][j] == 0){
                    int area = findArea(grid, islands, i, j, id++);
                    size.add(area);
                }
            }
        }

        int maxSize = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    List<Integer> nearbyIsland = new ArrayList<>();
                    int cur = 1;
                    for(int k = 0; k < dx.length; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length 
                        && grid[x][y] != 0){
                            int curid = islands[x][y];
                            if(!nearbyIsland.contains(curid)){
                                cur += size.get(curid - 1);
                                nearbyIsland.add(curid);
                            }
                        }
                    }
                    maxSize = max(cur, maxSize);
                }
            }
        }

        return maxSize!=0?maxSize:grid.length*grid[0].length;

    }

    public int findArea(int[][] grid, int[][] islands, int i, int j, int id){
        int res = 1;
        islands[i][j] = id;
        for(int k = 0; k < dx.length; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && 
            grid[x][y] == 1 && islands[x][y] != id){
                res += findArea(grid, islands, x, y, id);
            }
        }
        return res;
    }
}