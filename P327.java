import java.util.Arrays;

/*327. Count of Range Sum
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.*/

public class P327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null || nums.length==0) return 0;
		return countRangeSum(nums, lower, upper, 0, nums.length-1);
    }
	
	public int countRangeSum(int[] nums, int lower, int upper, int left, int right) {
		if(left==right) return ((nums[left]>=lower)&&(nums[right]<=upper))?1:0;
		int mid = left+(right-left)/2;
		long[] prefix = new long[right-mid];
		int sum = 0;
		for(int i=mid+1; i<=right; i++) {
			sum += nums[i];
			prefix[i-mid-1] = sum;
		}
		Arrays.sort(prefix);
		int count = 0;
		sum = 0;
		for(int i=mid; i>=left; i--) {
			sum += nums[i];
			count += findIndex(prefix, upper-sum+1)-findIndex(prefix, lower-sum);
		}
		return countRangeSum(nums, lower, upper, left, mid) + count + countRangeSum(nums, lower, upper, mid+1, right);
	}
	
	public int findIndex(long[] prefix, long value) {
		int left = 0;
		int right = prefix.length-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(prefix[mid] >= value) right = mid-1;
			else left = mid+1;
		}
		return left;
	}
}