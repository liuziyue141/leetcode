class Solution {
    public int longestOnes(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int res = 0;
        int cur = 0;
        int start = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(k == 0){
                    start = i + 1;
                }else if (list.size() == k){
                    start = list.pop() + 1;
                    list.add(i);
                }else{
                    list.add(i);
                }
            }
            res = Math.max(i - start + 1, res); 
        }
        return res;
    }
}