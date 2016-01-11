
/*
 * Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class P303 {
	private int[] nums;
	
	public P303(int[] nums) {
        this.nums = nums;
    }
	
	public int sumRange(int i, int j) {
        int count = 0;
        for(int k = i; k <= j; k++) {
        	count += nums[k];
        }
        return count;
    }
	
	public static void main(String[] args) {
//		P303 test = new P303(new int[]{-2, 0, 3, -5, 2, -1});
	}
}
