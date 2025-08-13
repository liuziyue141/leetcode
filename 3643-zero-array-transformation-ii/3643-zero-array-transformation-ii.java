class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {

        int cnt = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                cnt++;
            }
        }
        int step = 0;
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int v = query[2];
            if(cnt == nums.length){
                return step;
            }
            for(int i = l; i <= r; i++){
                if(nums[i]==0){
                    continue;
                }
                if(nums[i] <= v){
                    cnt++;
                }
                nums[i] = Math.max(nums[i] - v, 0);
            }
            System.out.println(step);
            step++;
        }
        if(cnt == nums.length){
            return step;
        }
        return -1;
    }
}