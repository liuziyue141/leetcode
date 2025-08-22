class Solution {
    public int[][] generateMatrix(int n) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][n];
        int row = 0;
        int col = -1;
        int cnt = 0;
        int val = 1;
        while(n-(cnt+1)/2 > 0){
            for(int i = 0; i < n - (cnt + 1)/2; i++){
                row += direction[cnt%4][0];
                col += direction[cnt%4][1];
                res[row][col] = val;
                val++;
            }
            cnt++;
        }

        return res;
    }
}