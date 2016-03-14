
/*123. Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.*/

public class P123 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
    	int[] left = new int[prices.length];
        int min = prices[0];
        for(int i=1; i<prices.length; i++) {
        	if(min>prices[i]) min = prices[i];
        	left[i] = Math.max(left[i-1], prices[i]-min);
        }
        int[] right = new int[prices.length];
        int max = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--) {
        	if(prices[i]>max) max = prices[i];
        	right[i] = Math.max(right[i+1], max-prices[i]);
        }
        int res = 0;
        for(int i=0; i<prices.length; i++) {
        	res = Math.max(res, left[i]+right[i]);
        }
        return res;
    }
}
