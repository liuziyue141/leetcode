class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n -1;

        while (l <= r){
            int mid = (l+r)/2;
            int midR = mid/n;
            int midC = mid%n;
            if(matrix[midR][midC] == target){
                return true;
            }else if(matrix[midR][midC] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return false;
    }
}