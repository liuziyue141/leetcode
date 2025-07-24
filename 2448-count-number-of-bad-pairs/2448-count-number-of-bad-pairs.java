class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            diff.put(i - nums[i], diff.getOrDefault(i-nums[i], 0) + 1);
        }
        long res = 0;
        for(int val : diff.values()){
            res += (nums.length - val)*(long)val;
        }
        return res/2;
    }

    // 3, 0, 1, 3
    // 3: 2
    // 0: 1
    // 1: 1



}