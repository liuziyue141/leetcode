class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        for(int[] query : queries){
            diff[query[0]]++;
            diff[query[1]+1]--;
        }

        for(int i = 0; i < nums.length; i++){
            diff[i+1] = diff[i+1] + diff[i];
            if(diff[i] < nums[i]){
                return false;
            }
        }
        return true; 
    }
}