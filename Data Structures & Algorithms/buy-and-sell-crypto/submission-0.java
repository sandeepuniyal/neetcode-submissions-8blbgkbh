class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, buy = prices[0];
        if(prices.length <=1)
            return 0;
        /*
        int[] profits = new int[prices.length];

        for(int i=0; i< profits.length; i++){
            profits[i] = 0;
        }
        */
        for(int i=1; i < prices.length; i++){
            if(prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return profit;
    }
}
