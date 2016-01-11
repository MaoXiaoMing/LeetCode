
public class P321 {

	
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int[][][] memo = new int[nums1.length+1][nums2.length+1][k+1];
    	int result[] = new int[k];
    	dp(nums1, nums2, k, memo, 0, 0, result);
    	return result;
    }
	
    public int dp(int[] nums1, int[] nums2, int k,
    		int[][][] memo, int start1, int start2, int[] result) {
    	if(k==0 || k>nums1.length+nums2.length) return 0;
    	if(start1<=nums1.length && start2<=nums2.length && memo[start1][start2][k] != 0) return memo[start1][start2][k];
    	int max = 0;
    	if(start1<nums1.length && start2<nums2.length) {
    		int res1 = dp(nums1, nums2, k, memo, start1+1, start2+1, result);
    		int res2 = dp(nums1, nums2, k, memo, start1+1, start2, result);
    		int res3 = dp(nums1, nums2, k, memo, start1, start2+1, result);
    		max = res1;
    		max = max<res2?res2:max;
    		max = max<res3?res3:max;
    	}
    	if(start1<nums1.length) {
    		int res = dp(nums1, nums2, k-1, memo, start1+1, start2, result);
    		int temp = res;
    		int sum = nums1[start1];
    		while(res > 0) {
    			sum *= 10;
    			res /= 10;
    		} 
    		sum += temp;
    		if(max < sum) {
        		max = sum;
        		result[result.length-k] = nums1[start1];
        	}
    	}
    	if(start2<nums2.length) {
    		int res = dp(nums1, nums2, k-1, memo, start1, start2+1, result);
    		int sum = nums1[start2];
    		int temp = res;
    		while(res > 0) {
    			sum *= 10;
    			res /= 10;
    		} 
    		sum += temp;
    		if(max < sum) {
        		max = sum;
        		result[result.length-k] = nums2[start2];
        	}
    	}
    	return memo[start1][start2][k]=max;
    }
    
	public static void main(String[] args) {
		P321 p = new P321();
		int[] res = p.maxNumber(new int[]{3,9}, new int[]{8}, 2);
//		int[] res = p.maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]);
		}
	}

}
