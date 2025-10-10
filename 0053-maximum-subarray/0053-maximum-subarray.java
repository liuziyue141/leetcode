class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int curVal = nums[0]; 
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            curVal = Math.max(num, curVal + num);
            curMax = Math.max(curMax, curVal);
        }
        return curMax;
    }
}