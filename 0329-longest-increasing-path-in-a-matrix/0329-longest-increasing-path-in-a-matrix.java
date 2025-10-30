class Solution {
    int maxlength;
    public int longestIncreasingPath(int[][] matrix) {
        maxlength = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int length = dfs(i, j, matrix, memo);
                maxlength = Math.max(length, maxlength);
            }
        }
        return maxlength;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] memo){
        
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int newLength = 1;
        if(i+1 != matrix.length && matrix[i+1][j] > matrix[i][j]){
            newLength = dfs(i+1, j, matrix, memo) + 1;
        }
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            newLength = Math.max(dfs(i-1, j, matrix, memo) + 1, newLength);
        }
        if(j+1 != matrix[0].length && matrix[i][j+1] > matrix[i][j]){
            newLength = Math.max(dfs(i, j + 1, matrix, memo) + 1, newLength);
        }
        if(j-1 >=0 && matrix[i][j-1] > matrix[i][j]){
            newLength = Math.max(dfs(i, j - 1, matrix, memo) + 1, newLength);
        }
        memo[i][j] = newLength;

        return memo[i][j];
    }
}