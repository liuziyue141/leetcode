class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] coord = q.poll();
                if(coord[1] == n-1 && coord[0] == n-1){
                    return cnt;
                }
                for(int j = 0; j < dx.length; j++){
                    int x = coord[0] + dx[j];
                    int y = coord[1] + dy[j];
                    if(x < n && y < n && x >= 0 && y >= 0 && grid[x][y] == 0){
                        grid[x][y] = 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}