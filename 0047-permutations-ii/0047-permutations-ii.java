class Solution {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int num : nums){
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(res, cur, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
        }
        for(int i = 0; i < nums.length; i++){
            if((i == 0 || nums[i] != nums[i-1]) && freqMap.get(nums[i]) != 0){
                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                cur.add(nums[i]);
                backtrack(res, cur, nums);
                cur.remove(cur.size() - 1);
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            }
        }
    }
}