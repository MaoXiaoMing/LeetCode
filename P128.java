import java.util.HashMap;
import java.util.Map;

/*
 * 128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class P128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> length = new HashMap<>();
        for(int num : nums) 
        	length.put(num, 0);
        int max = 0;
        for(int num : nums) {
        	if(length.get(num)!=0) continue;
        	length.put(num, 1);
        	int result = 1;
        	int left = num;
        	while(length.containsKey(--left)) {
        		length.put(left, 1);
        		result++;
        	}
        	int right = num;
        	while(length.containsKey(++right)) {
        		length.put(right, 1);
        		result++;
        	}
        	max = Math.max(result, max);
        }
        return max;
    }	
	
	public static void main(String[] args) {
		P128 test = new P128();
		test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
	}

}
