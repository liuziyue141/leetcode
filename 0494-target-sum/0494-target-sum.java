class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, int idx){
        if(idx == nums.length){
            if(target == 0) {res++;}
            return;
        }

        backtrack(nums, target - nums[idx], idx+1);
        backtrack(nums, target + nums[idx], idx+1);

    }
}