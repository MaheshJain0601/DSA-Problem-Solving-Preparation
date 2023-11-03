class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int day = 0;
        int minPrice = prices[day];
        
        for (day = 1; day < prices.length; ++day) {
            minPrice = Math.min(minPrice, prices[day]);
            maxProfit = Math.max(maxProfit, prices[day] - minPrice);
        }
        return maxProfit;
    }
}