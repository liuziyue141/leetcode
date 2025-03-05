class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if(!numMap.containsKey(num)){
                int totalLen = 0;
                if(numMap.containsKey(num + 1) && numMap.containsKey(num - 1)){
                    numMap.put(num, 1);
                    int r = num + numMap.get(num + 1);
                    int l = num - numMap.get(num - 1);
                    totalLen = numMap.get(l) + numMap.get(r) + 1;
                    numMap.put(l, totalLen);
                    numMap.put(r, totalLen);
                }else if(numMap.containsKey(num + 1)){
                    int r = num + numMap.get(num + 1);
                    totalLen = numMap.get(r) + 1;
                    numMap.put(r, totalLen);
                    numMap.put(num, totalLen);
                }else if(numMap.containsKey(num - 1)){
                    int l = num - numMap.get(num - 1);
                    totalLen = numMap.get(l) + 1;
                    numMap.put(l, totalLen);
                    numMap.put(num, totalLen);
                }else{
                    totalLen = 1;
                    numMap.put(num, totalLen);
                }
                res = Math.max(res, totalLen);
            } 
        }
        return res;
    }
}