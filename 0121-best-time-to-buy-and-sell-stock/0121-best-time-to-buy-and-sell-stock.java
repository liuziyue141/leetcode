class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyP = prices[0];
        for(int i = 0; i < prices.length; i++){
            buyP = Math.min(buyP, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buyP);
        }

        return maxProfit;

    }
}