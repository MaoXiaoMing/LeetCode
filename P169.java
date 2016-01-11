
/*
 * Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.*/

public class P169 {
/*  int index = 0;
    int key = nums[0];
	for(int i=1; i<nums.length; i++) {
    	if(nums[i] <= key) {
    		index++;
    		int temp = nums[i];
    		nums[i] = nums[index];
    		nums[index] = temp;
    	}
    }
	int temp = nums[index];
	nums[index] = key;
	nums[0] = temp;
	return nums[nums.length/2];*/
	public static int majorityElement(int[] nums) {
		int res = nums[0];
		int count = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == res) {
				count++;
			}else{
//				count--;
				if(count == 0) {
					res = nums[i];
					count = 1;
				}else {
					count --;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{3,2};
		System.out.println(majorityElement(test));
		System.out.println();
	}
}
