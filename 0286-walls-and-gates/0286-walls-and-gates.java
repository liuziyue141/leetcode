class Solution {
    public void wallsAndGates(int[][] rooms) {
        LinkedList<int[]> queue = new LinkedList<>();
        int space = Integer.MAX_VALUE;
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int cnt = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];
                    if(x >= 0 && x < m &&
                        y >= 0 && y < n && rooms[x][y] == space){
                            rooms[x][y] = cnt;
                            queue.add(new int[]{x, y});
                        }
                }
            }
            cnt++;
        }   
    }
}