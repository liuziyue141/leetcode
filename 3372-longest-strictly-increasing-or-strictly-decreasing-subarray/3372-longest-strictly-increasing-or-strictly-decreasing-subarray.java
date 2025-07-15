class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int last = nums[0];
        int cur = 1;
        boolean ascending = true;
        for(int i = 1; i < nums.length; i++){
            if(ascending && nums[i] > last){
                cur += 1;
            }else if(ascending && nums[i] < last){
                cur = 2;
                ascending = false;
            }else if(!ascending && nums[i] > last){
                cur = 2;
                ascending = true;
            }else if(!ascending && nums[i] < last){
                cur += 1;
            }else{
                cur = 1;
            }
            last = nums[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}