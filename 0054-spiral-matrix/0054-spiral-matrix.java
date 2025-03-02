class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length; int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        
        int r = 0; int c = 0; int dirCnt = 0;
        int up = 0; int down = m; int left = 0; int right = n;

        while (up < down && left < right){
            while(r >=up && c >=left && r < down && c < right){
                res.add(matrix[r][c]);
                r += delta[dirCnt][0];
                c += delta[dirCnt][1];
            }
            if(dirCnt == 0){
                up++;
            }else if(dirCnt == 1){
                right--;
            }else if(dirCnt == 2){
                down--;
            }else{
                left++;
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