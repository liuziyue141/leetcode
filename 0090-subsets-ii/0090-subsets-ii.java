class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> cur = new HashMap<>();
        Set<HashMap<Integer, Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        subsetsWithDup(nums, 0, cur, set, list);

        return list;
    }

    public void subsetsWithDup(int[] nums, int idx, HashMap<Integer, Integer> cur, Set<HashMap<Integer, Integer>> set, List<List<Integer>> result){
        if(!set.contains(cur)){
            set.add(new HashMap<>(cur));
            List<Integer> resElem = new ArrayList<>();
            for(Integer key : cur.keySet()){
                for(int i = 0; i < cur.get(key); i++){
                    resElem.add(key);
                }
            }
            result.add(resElem);
        }

        for(int i = idx; i < nums.length; i++){
            cur.put(nums[i], cur.getOrDefault(nums[i], 0) + 1);
            subsetsWithDup(nums, i + 1, cur, set, result);
            int cnt = cur.get(nums[i]) - 1;
            if(cnt == 0){
                cur.remove(nums[i]);
            }else{
                cur.put(nums[i], cnt);
            }
            
        }
    }
}