class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while(j < matrix[0].length && i >= 0){
            while(j < matrix[0].length && matrix[i][j] < target){
                j++;
            }
            if(j == matrix[0].length){
                return false;
            }

            if(matrix[i][j] == target){
                return true;
            }

            while(i>=0 && matrix[i][j] > target){
                i--;
            }
            if(i < 0){
                return false;
            }
            if(matrix[i][j] == target){
                return true;
            }
        }

        return false;
    }
}