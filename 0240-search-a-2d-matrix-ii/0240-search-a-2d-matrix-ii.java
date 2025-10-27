class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while(j < matrix[0].length && i >= 0){

            // use binary search to find the minimum value that is greater than target
            int l = j;
            int r = matrix[0].length - 1;
            int res = -1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(matrix[i][mid] == target){
                    return true;
                }else if(matrix[i][mid] > target){
                    res = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }

            }
            System.out.println(res);
            if(res == -1){
                return false;
            }
             j = res;

            

            // use binary search to find the maximum value that is less than target
            l = 0;
            r = i;
            res = -1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(matrix[mid][j] == target){
                    return true;
                }else if(matrix[mid][j] > target){
                    r = mid - 1;
                }else{
                    res = mid;
                    l = mid + 1;
                }
            }
            if(res == -1){
                return false;
            }

            i = res;
        }

        return false;
    }
}