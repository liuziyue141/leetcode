class Solution {
    int[][] total;
    int[][] grid;
    int[][] reached;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int shortestDistance(int[][] grid) {
        total = new int[grid.length][grid[0].length];
        this.grid = grid;
        reached = new int[grid.length][grid[0].length];
        
        Queue<int[]> q = new LinkedList<>(); 
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j});
                    cnt++;
                    bfs(q);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(reached[i][j] == cnt && total[i][j] < min){
                    min = total[i][j];
                }
            }
        }
        return min==Integer.MAX_VALUE? -1:min;
    }

    public void bfs(Queue<int[]>q){
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                total[x][y] += step;
                for(int j = 0; j < dx.length; j++){
                    int nX = x + dx[j];
                    int nY = y + dy[j];
                    if(nX >= 0 && nX < grid.length
                    && nY >= 0 && nY < grid[0].length && 
                    grid[nX][nY] == 0 && !visited[nX][nY]){
                        q.add(new int[]{nX, nY});
                        reached[nX][nY]++;
                        visited[nX][nY] = true;
                    }
                }

            }
            step++;

        }
    }
}