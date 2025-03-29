class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> vancancy = new HashMap<>();

        for(int num : nums){
            int curfreq = freq.getOrDefault(num, 0);
            freq.put(num, curfreq + 1);
        }

        for(int i = 0; i < nums.length; i++){
            if(freq.get(nums[i]) == 0){
                continue;
            }
            if(vancancy.getOrDefault(nums[i], 0) > 0){
                freq.put(nums[i], freq.get(nums[i]) - 1);
                vancancy.put(nums[i], vancancy.get(nums[i]) - 1);
                vancancy.put(nums[i] + 1, vancancy.getOrDefault(nums[i] + 1, 0) + 1);
            }else if ( freq.getOrDefault(nums[i] + 1, 0) > 0 && freq.getOrDefault(nums[i] + 2, 0) > 0){
                freq.put(nums[i], freq.get(nums[i]) - 1);
                freq.put(nums[i] + 1, freq.get(nums[i] + 1) - 1);
                freq.put(nums[i] + 2, freq.get(nums[i] + 2) - 1);
                vancancy.put(nums[i] + 3, vancancy.getOrDefault(nums[i] + 3, 0) + 1);
            }else{
                return false;
            }
        }
        return true;
    }
}