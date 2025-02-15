class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int mean = sum / k;
        if(sum % k != 0){
            return false;
        }
        Integer[] numsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new); // Convert to Integer array
        Arrays.sort(numsInteger, (Integer a, Integer b) -> b - a);
        int[] cnt = new int[k];

        return helper(numsInteger, cnt, mean, 0);
    }

    public boolean helper(Integer[] nums, int[] cnt, int target, int idx){
        if(idx==nums.length){
            return true;
        }
        for(int i = 0; i < cnt.length; i++){
            if(i > 0 && cnt[i] == cnt[i-1]){
                continue;
            }
            cnt[i]+=nums[idx];
            if(cnt[i] <= target && helper(nums, cnt, target, idx+1)){
                return true;
            }
            cnt[i]-=nums[idx];
        }
        return false;
    }
}