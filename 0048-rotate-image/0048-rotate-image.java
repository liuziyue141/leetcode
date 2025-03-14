class Solution {
    
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length - 1);
    }
    
    public void rotate(int[][] matrix, int l, int r) {
        if(r<=l){
            return;
        }
        int temp = 0;
        for(int i = l; i < r; i++){
            temp = matrix[i][r];
            matrix[i][r] = matrix[l][i];
            matrix[l][i] = temp;

            temp = matrix[r][r-i+l];
            matrix[r][r-i+l] = matrix[l][i];
            matrix[l][i] = temp;


            temp = matrix[r-i+l][l];
            matrix[r-i+l][l] = matrix[l][i];
            matrix[l][i] = temp;
        }
        rotate(matrix, l+1, r-1);
        
    }

}