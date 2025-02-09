class Solution {
    public int findPeakElement(int[] nums) {
        boolean lastGreater = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                lastGreater = true;
            }else if(lastGreater){
                return i - 1;
            }
        }
        return nums.length-1;
    }
}