class Solution {
    
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // each element --> LinkedList 
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        HashMap<Integer, Integer> numMap = new HashMap<>();
        List<LinkedList<Integer>> queueList = new ArrayList<>();
        for(int i = 0; i < copy.length; i++){
            int idx = 0;
            if(i == 0 || copy[i] - copy[i - 1] > limit){
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(copy[i]);
                idx = queueList.size();
                queueList.add(queue);
            }else{
                idx = numMap.get(copy[i-1]);
                queueList.get(idx).add(copy[i]);
            }
            numMap.put(copy[i], idx);
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = queueList.get(numMap.get(nums[i])).pop();
        }
        return nums;
    }
}

