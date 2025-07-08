class Solution {
    public int subarraySum(int[] nums, int k) {
        //[1,1,1] -> 0, 1, 2, 3 
        // hashmap key prefix value cnt
        // cnt += hashmap[prefix - k]

        int[] prefix = new int[nums.length + 1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix[i+1] = sum;
        }

        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        int cnt = 0; 
        for(int i = 1; i < prefix.length; i++){
            int cur = prefix[i];
            cnt += cntMap.getOrDefault(prefix[i] - k, 0);
            cntMap.put(prefix[i], cntMap.getOrDefault(prefix[i], 0) + 1);
        }
        return cnt;
    }
}