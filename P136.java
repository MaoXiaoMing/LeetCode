
/*
 * 136. Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
*/
public class P136 {

    public int singleNumber(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
        for(int i=1; i<nums.length; i++) {
        	nums[0] ^= nums[i];
        }
        return nums[0];
    }
	
	public static void main(String[] args) {

	}

}
