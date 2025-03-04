class Solution {
    // public int maxProfit(int[] prices) {
    //     int maxProfit = 0;
    //     int buyP = prices[0];
    //     for(int i = 0; i < prices.length; i++){
    //         buyP = Math.min(buyP, prices[i]);
    //         maxProfit = Math.max(maxProfit, prices[i] - buyP);
    //     }

    //     return maxProfit;

    // }

    public int maxProfit(int[] prices) {
        int[] diff = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            diff[i] = prices[i] - prices[i-1];
        }

        int maxProfit = 0;
        int lastProfit = 0;

        for(int i = 1; i < diff.length; i++){
            lastProfit = Math.max(diff[i] + lastProfit, diff[i]);
            maxProfit = Math.max(maxProfit, lastProfit);
        }
        return maxProfit;

    }
}