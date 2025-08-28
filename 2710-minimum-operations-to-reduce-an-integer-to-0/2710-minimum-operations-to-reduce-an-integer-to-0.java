class Solution {
    public int minOperations(int n) {
        int totalOpts = 0;
        while(n > 0){
            int cnt = 0;
            while(n%2 == 0){
                n = n>>1;
            }
            while(n%2 == 1){
                cnt++;
                n = n >> 1;
            }
            if(cnt == 0){
                n = n>>1;
            }
            if(cnt == 1){
                totalOpts += 1;
            }
            if(cnt >= 2){
                totalOpts += 1;
                n = n + 1;
            }
        }

        return totalOpts;
    }
}