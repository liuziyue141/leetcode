class Solution {
    public int candy(int[] ratings) {
        int left = 0;
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = 1;
            }
        }
    
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]);
            }
        }
        int cnt = 0;
        for(int i = 0; i < ratings.length; i++){
            cnt += dp[i];
        }

        return cnt; 
    }
}