class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        boolean hasChange = true;
        
        int r = 0;
        int c = 0;
        boolean modified = true;
        int cnt = 0;
        int dirCnt = 0;

        while (modified){
            modified = false;
            while(r >=0 && c >=0 && r < m && c < n && !seen[r][c]){
                modified = true;
                seen[r][c] = true;
                res.add(matrix[r][c]);
                cnt++;
                r += delta[dirCnt][0];
                c += delta[dirCnt][1];
            }
            r -= delta[dirCnt][0];
            c -= delta[dirCnt][1];
            dirCnt = (dirCnt + 1)%4;
            r += delta[dirCnt][0];
            c += delta[dirCnt][1];
        }
        return res;
    }
}