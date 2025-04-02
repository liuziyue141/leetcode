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
        for(int i = 0; i < ratings.length/2; i++){
            int temp = ratings[i];
            ratings[i] = ratings[ratings.length - 1 - i];
            ratings[ratings.length - 1 - i] = temp;

            temp = dp[i];
            dp[i] = dp[ratings.length - 1 - i];
            dp[ratings.length - 1 - i] = temp;
        }
        // System.out.println(Arrays.toString(ratings));
        // System.out.println(Arrays.toString(dp));
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
        }
        // System.out.println(Arrays.toString(dp));
        int cnt = 0;
        for(int i = 0; i < ratings.length; i++){
            cnt += dp[i];
        }

        return cnt; 
    }
}