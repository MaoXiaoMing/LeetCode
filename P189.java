/*
 * Rotate Array
 * 1. 每次向右移动一位
 * 2. 开辟一片新的空间存储部分数组
 * 3. 三次交换
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.*/

public class P189 {
	public void exchange(int[] nums, int low, int high) {
		for(int i=low; i<=(low+high)/2; i++) {
			int temp = nums[i];
			nums[i] = nums[high-i+low];
			nums[high-i+low] = temp;
		}
		
	}
	
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		if(k <= 0) return ;
		k = nums.length-k;
        exchange(nums, 0, k-1);
        exchange(nums, k, nums.length-1);
        exchange(nums, 0, nums.length-1);
    }
	
	public static void main(String[] args) {
		int[] test = new int[]{1,2,3,4,5,6,7};
		new P189().rotate(test, 3);
		System.exit(-1);
	}
}
