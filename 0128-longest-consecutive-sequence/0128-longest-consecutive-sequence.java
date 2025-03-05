class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if(!numMap.containsKey(num)){
                int r = num + numMap.getOrDefault(num+1, 0);
                int l = num - numMap.getOrDefault(num-1, 0);
                int totalLen = numMap.getOrDefault(r, 0) + numMap.getOrDefault(l, 0) + 1;
                numMap.put(num, totalLen);
                numMap.put(r, totalLen);
                numMap.put(l, totalLen);
                res = Math.max(res, totalLen);
                
            } 
        }
        return res;
    }
}