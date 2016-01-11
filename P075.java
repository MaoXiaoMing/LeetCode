
/*
 * Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/
public class P075 {

    public void sortColors(int[] nums) {
        int[] index = new int[3];
        for(int i : nums) index[i]++;
        for(int i=0; i<nums.length; i++) {
        	if(i<index[0]) {
        		nums[i] = 0;
        	}else if(i<index[0]+index[1]) {
        		nums[i] = 1;
        	}else {
        		nums[i] = 2;
        	}
        }
    }
	
	public static void main(String[] args) {

	}

}
