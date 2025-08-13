class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int sum = 0;
        int cnt = 0;
        int[] diff = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            while(sum + diff[i] < nums[i]){
                if(cnt >= queries.length){
                    return -1;
                }

                int[] query = queries[cnt];
                if(query[1] >= i){
                    diff[Math.max(query[0], i)] += query[2];
                    diff[query[1]+1] -= query[2];
                }
                cnt++;
            }
            sum += diff[i];
        }
        return cnt;
    }
}