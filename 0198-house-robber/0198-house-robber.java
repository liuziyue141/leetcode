class Solution {
    public int rob(int[] nums) {
        int lastTwo = 0;
        int lastOne = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = lastOne;
            lastOne = Math.max(lastTwo + nums[i], lastOne);
            lastTwo = temp;
        }
        return lastOne;
    }
}