class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if(!numMap.containsKey(num)){
                int r = numMap.getOrDefault(num+1, 0);
                int l = numMap.getOrDefault(num-1, 0);
                int totalLen = l + r + 1;
                numMap.put(num, totalLen);
                numMap.put(num + r, totalLen);
                numMap.put(num - l, totalLen);
                res = Math.max(res, totalLen);
                
            } 
        }
        return res;
    }
}