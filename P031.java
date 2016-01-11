import java.util.Arrays;

/*31. Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

  */
public class P031 {
	
	public void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
	
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;
        for(int i=nums.length-2; i>=0; i--) {
        	if(index1 != -1) break;
        	for(int j=nums.length-1; index1==-1&&j>i; j--) {
        		if(nums[i] < nums[j]) {
        			index1 = i;
        			index2 = j;
        		}
        	}
        }
        if(index1 == -1) {
        	Arrays.sort(nums, 0, nums.length);
        }else {
        	swap(nums, index1, index2);
        	Arrays.sort(nums, index1+1, nums.length);
        }
    }
    
	public static void main(String[] args) {
		int[] input = new int[]{1,4,3,2};
		new P031().nextPermutation(input);
		for(int i=0; i<input.length; i++) {
			System.out.println(input[i]);
		}
	}
}
