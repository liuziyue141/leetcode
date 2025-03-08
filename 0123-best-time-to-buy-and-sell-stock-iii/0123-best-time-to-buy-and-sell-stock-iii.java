class Solution {
    public int maxProfit(int[] prices) {
        int[] bestBuyTo = new int[prices.length];
        int[] bestBuyFrom = new int[prices.length];

        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            min = Math.min(prices[i], min);
            bestBuyTo[i] = Math.max(bestBuyTo[i - 1], prices[i] - min);
        }

        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(prices[i], max);
            bestBuyFrom[i] = Math.max(bestBuyFrom[i + 1], max - prices[i]);
        }

        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            profit = Math.max(profit, bestBuyTo[i] + bestBuyFrom[i]);
        }
        return profit;
    }

    // int[][][] dp;
    // public int maxProfit(int[] prices) {
    //     dp = new int[2][2][prices.length];
    //     for(int i = 0; i < 2; i++){
    //         for(int j = 0; j < 2; j++){
    //             for(int k = 0; k < prices.length; k++){
    //                 dp[i][j][k] = -1;
    //             }
    //         }
    //     }
    //     int res = maxProfit(prices, 0, 0, 0);
    //     return res;
    // }

    // public int maxProfit(int[] prices, int day, int buy, int transaction){
    //     if(day >= prices.length || transaction >= 2){
    //         return 0;
    //     }
    //     if(dp[buy][transaction][day]!= -1){
    //         return dp[buy][transaction][day];
    //     }
    //     int result = maxProfit(prices, day + 1, buy, transaction);
    //     if(buy == 1){
    //         result = Math.max(result, prices[day] + maxProfit(prices, day + 1, 0, transaction + 1));
    //     }else{
    //         result = Math.max(result, maxProfit(prices, day + 1, 1, transaction) - prices[day]);
    //     }
    //     dp[buy][transaction][day] = result;
    //     return result;
    // }
}