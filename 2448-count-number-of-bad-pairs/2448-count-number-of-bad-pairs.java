class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            diff.put(i - nums[i], diff.getOrDefault(i-nums[i], 0) + 1);
        }
        long total = (long)nums.length * (nums.length - 1) / 2;
        long good = 0;
        for(int val : diff.values()){
            good += (long)val * (val - 1)/2;
        }
        return total - good;
    }

    // 3, 0, 1, 3
    // 3: 2
    // 0: 1
    // 1: 1



}