import java.util.Arrays;

/*322. Coin Change
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.*/
public class P322 {

    public int coinChange(int[] coins, int amount) {
    	int[] memo = new int[amount+1];
    	Arrays.sort(coins);
    	for(int i=1; i<=amount; i++) {
    		int min = Integer.MAX_VALUE;
    		for(int coin : coins) {
    			if(i-coin>=0 && (i-coin==0 || memo[i-coin]!=-1))
    				min = Math.min(min, memo[i-coin]+1);
    		}
    		memo[i] = min==Integer.MAX_VALUE?-1:min;
    	}
    	return memo[amount];
    } 
	
	public static void main(String[] args) {
		P322 test = new P322();
		System.out.print(test.coinChange(new int[]{1,2,5}, 42));
	}

}
