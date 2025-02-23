class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[mat.length][mat[0].length]; 
        int[][] res = new int[mat.length][mat[0].length];
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.addLast(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.removeFirst();
                for(int j = 0; j < 4; j++){
                    int nx = cur[0]+dx[j];
                    int ny = cur[1]+dy[j];
                    if(nx < m && nx >= 0 && ny < n && ny >=0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        res[nx][ny] = res[cur[0]][cur[1]] + 1;
                        q.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return res;
    }
                        
}