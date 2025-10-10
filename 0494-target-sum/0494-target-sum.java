class Solution {
    Map<Integer, Map<Integer, Integer>>memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        int res = backtrack(nums, target, 0);
        return res;
    }

    public int backtrack(int[] nums, int target, int idx){
        if(idx == nums.length && target == 0){
            return 1;
        }
        if(idx == nums.length){
            return 0;
        }
        if(memo.containsKey(target)){
            if(memo.get(target).containsKey(idx)){
                return memo.get(target).get(idx);
            }
        }
        int cnt = backtrack(nums, target - nums[idx], idx+1);
        cnt += backtrack(nums, target + nums[idx], idx+1);
        memo.putIfAbsent(target, new HashMap<>());
        memo.get(target).put(idx, cnt);
        return cnt;
    }
}