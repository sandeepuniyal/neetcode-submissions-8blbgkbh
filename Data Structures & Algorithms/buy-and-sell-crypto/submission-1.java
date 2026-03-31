class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, minBuy = prices[0];
        
        for(int sell: prices){
            profit = Math.max(profit, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return profit;
    }
}
