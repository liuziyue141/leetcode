class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //range binary sort solution:

        int hi = matrix[matrix.length-1][matrix.length-1];
        int lo = matrix[0][0];

        while(lo<=hi){
            int mid = (hi+lo)/2;

            int count = 0;
            int maxNum = -10000;

            // invariant established here
            for(int i = 0; i < matrix.length; i++){
                int j = 0;
                while(j < matrix.length && matrix[i][j]<=mid){
                    maxNum = Math.max(maxNum, matrix[i][j]);
                    j++;
                }
                count += j;
            }

            if(count == k){
                return maxNum;
            }else if(count < k){
                lo = mid + 1;
            }else{
                hi = mid -1;
            }
        }
        return lo;
    }
}