class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // here the datastructure map the integer value to max conseutive sequence length
        // we need to check whether integer already existed in the map. If existed, ignore
        // we need to find the max sequence of value + 1 and value - 1
        // update the value in the map accordingly
        int max = 0;
        for(int num : nums){
            if(map.containsKey(num)){
                continue;
            }

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            map.put(num, 1);
            map.put(num - left, right + left + 1);
            map.put(num + right, left + right + 1);
            max = Math.max(max, right + left + 1);
        }

        return max;
    }
}