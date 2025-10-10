class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int curVal = nums[0]; 
        for(int i = 1; i < nums.length; i++){
            if(curVal < 0){
                curVal = 0;
            }
            curVal += nums[i];
            curMax = Math.max(curMax, curVal);
        }
        return curMax;
    }
}