class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[2][2][prices.length];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < prices.length; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int res = maxProfit(prices, 0, 0, 0);
        return res;
    }

    public int maxProfit(int[] prices, int day, int buy, int transaction){
        if(day >= prices.length || transaction >= 2){
            return 0;
        }
        if(dp[buy][transaction][day]!= -1){
            return dp[buy][transaction][day];
        }
        int result = maxProfit(prices, day + 1, buy, transaction);
        if(buy == 1){
            result = Math.max(result, prices[day] + maxProfit(prices, day + 1, 0, transaction + 1));
        }else{
            result = Math.max(result, maxProfit(prices, day + 1, 1, transaction) - prices[day]);
        }
        dp[buy][transaction][day] = result;
        return result;
    }
}