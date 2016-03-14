import java.util.Arrays;
import java.util.List;

/*315. Count of Smaller Numbers After Self
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].*/

public class P315 {
	private class Number {
		int count;
		int index;
		int value;
		
		Number(int value, int index) {
			this.count = 0;
			this.index = index;
			this.value = value;
		}
	}
	
    public List<Integer> countSmaller(int[] nums) {
        Number[] numbers = new Number[nums.length];
        for(int i=0; i<nums.length; i++) 
        	numbers[i] = new Number(nums[i], i);
        mergeSort(numbers, 0, nums.length-1);
        Integer[] res = new Integer[nums.length];
        for(int i=0; i<numbers.length; i++) 
        	res[numbers[i].index] = numbers[i].count;
        return Arrays.asList(res);
    }
    
    public void mergeSort(Number[] numbers, int start, int end) {
    	if(start < end) {
			int mid = start+(end-start)/2;
			mergeSort(numbers, start, mid);
			mergeSort(numbers, mid+1, end);
			merge(numbers, start, mid, end);
		}
    }
    
	public void merge(Number[] numbers, int start, int mid, int end) {
		Number[] mem = new Number[end-start+1];
		int left = start ;
		int right = mid+1;
		int rightCount = 0;
		int pos = 0;
		while(left<=mid && right<=end) {
			if(numbers[left].value <= numbers[right].value) {
				numbers[left].count += rightCount;
				mem[pos++] = numbers[left++];
			}else {
				rightCount++;
				mem[pos++] = numbers[right++];
			}
		}
		while(left<=mid) {
			numbers[left].count += rightCount;			
			mem[pos++] = numbers[left++];
		}
		while(right<=end) 
			mem[pos++] = numbers[right++];
		System.arraycopy(mem, 0, numbers, start, mem.length);
	}
	
	public static void main(String[] args) {
		P315 test = new P315();
		test.countSmaller(new int[]{5,2,6,1});
	}

}
