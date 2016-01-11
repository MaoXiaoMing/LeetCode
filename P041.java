
/*
 * 41. First Missing Positive
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class P041 {
	
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
        	while(nums[i]>=1 && nums[i]<=nums.length && nums[i]-1!=i && nums[nums[i]-1]!=nums[i]) {
        		int temp = nums[nums[i]-1];
        		nums[nums[i]-1] = nums[i];
        		nums[i] = temp;
        	}
        }
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    
	public static void main(String[] args) {
		P041 p = new P041();
		System.out.println(p.firstMissingPositive(new int[]{4,3,7,6,4}));
	}

}
