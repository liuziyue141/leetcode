class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = Integer.MIN_VALUE;
        int curVal = 0; 
        for(int i = 0; i < nums.length; i++){
            curVal += nums[i];
            curMax = Math.max(curMax, curVal);
            if(curVal < 0){
                curVal = 0;
            }
        }
        return curMax;
    }
}