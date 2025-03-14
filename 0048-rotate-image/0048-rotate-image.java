class Solution {
    
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length - 1);
    }
    
    public void rotate(int[][] matrix, int l, int r) {
        if(r<=l){
            return;
        }
        int temp = 0;
        int u = l;
        int b = r;
        for(int i = 0; i < r - l; i++){
            temp = matrix[u+i][r];
            matrix[u+i][r] = matrix[u][l+i];
            matrix[u][l+i] = temp;

            temp = matrix[b][r-i];
            matrix[b][r-i] = matrix[u][l+i];
            matrix[u][l+i] = temp;


            temp = matrix[b-i][l];
            matrix[b-i][l] = matrix[u][l+i];
            matrix[u][l+i] = temp;
        }
        rotate(matrix, l+1, r-1);
        
    }

}