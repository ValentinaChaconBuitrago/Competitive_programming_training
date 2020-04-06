class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        int i=0;
        while(i<prices.length){
            while(i<prices.length && prices[i]<min){
                min = prices[i];
                i++;
            }
            max = min;
            while(i<prices.length && prices[i]>max){
                max = prices[i];
                i++;
            }
            profit+=(max-min);
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        return profit;

    }
}