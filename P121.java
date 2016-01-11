
/*
 * 121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Subscribe to see which companies asked this question
*/
public class P121 {

    public int maxProfit(int[] prices) {
    	int res = Integer.MIN_VALUE;
    	int max =Integer.MIN_VALUE;
        for(int i=prices.length-1; i>=0; i--) {
        	if(max<prices[i]) max = prices[i];
        	if(max-prices[i] > res) 
        		res = max-prices[i];
        }
        return res;
    }
	
	public static void main(String[] args) {

	}

}
