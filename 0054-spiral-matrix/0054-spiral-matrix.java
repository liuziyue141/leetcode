class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        
        int r = 0; int c = 0; int dirCnt = 0;
        int up = 0; int down = m; int left = 0; int right = n;

        while (up < down && left < right){ 
            if(dirCnt == 0){
                for(int i = left; i < right; i++){
                    res.add(matrix[up][i]);
                }
                up++;
            }else if(dirCnt == 1){
                for(int i = up; i < down; i++){
                    res.add(matrix[i][right-1]);
                }
                right--;
            }else if(dirCnt == 2){
                for(int i = right - 1; i >= left; i--){
                    res.add(matrix[down-1][i]);
                }
                down--;

            }else{
                for(int i = down -1; i >= up; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dirCnt = (dirCnt + 1)%4;
        }
        return res;
    }
}