class Solution {
    public int maximumProduct(int[] nums) {
        int hs = Math.max(nums[0], nums[1]);
        int ls = Math.min(nums[0], nums[1]);
        int ht = nums[0] * nums[1];
        int lt = nums[0] * nums[1];

        int res = Integer.MIN_VALUE;

        for(int i = 2; i < nums.length; i++){
            res = Math.max(res, ht*nums[i]);
            res = Math.max(res, lt*nums[i]);

            ht = Math.max(ht, hs * nums[i]);
            ht = Math.max(ht, ls * nums[i]);

            lt = Math.min(lt, hs * nums[i]);
            lt = Math.min(lt, ls * nums[i]);

            ls = Math.min(ls, nums[i]);
            hs = Math.max(hs, nums[i]);
        }
        return res;
    }
}