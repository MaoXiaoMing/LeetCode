
/*188. Best Time to Buy and Sell Stock IV
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/

public class P188 {
    public int maxProfit(int k, int[] prices) {
    	int[] hold = new int[k];
    	int[] release = new int[k];
    	for(int i=0; i<hold.length; i++) hold[i] = Integer.MIN_VALUE;
    	for(int i=0; i<prices.length; i++) {
    		for(int j=k-1; j>=1; j--) {
    			release[j] = Math.max(release[j], hold[j]+prices[i]);
    			hold[j] = Math.max(hold[j], release[j-1]-prices[i]);
    		}
    		release[0] = Math.max(release[0], hold[0]+prices[i]);
    		hold[0] = Math.max(hold[0], -prices[i]);
    	}
    	return release[k-1];
    }
}
