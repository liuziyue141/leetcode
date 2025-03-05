class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> lceMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            lceMap.put(nums[i], 1);
        }
        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i] + 1;
            int curCnt = 1;
            while(lceMap.containsKey(cur) && !visited.contains(cur)){
                curCnt += lceMap.get(cur);
                visited.add(cur);
                cur++;
            }
            lceMap.put(nums[i], Math.max(curCnt, lceMap.get(nums[i])));
            res = Math.max(curCnt, res);
        }
        return res;
    }
}