import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 1. Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * */
public class P001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		List<Integer> list = map.get(nums[i]);
        		list.add(i);
        		map.put(nums[i], list);
        	}else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(nums[i], list);
        	}
        }
        for(Iterator<Integer> iter=map.keySet().iterator(); iter.hasNext(); ) {
        	int value = iter.next();
        	int other = target-value;
        	List<Integer> list = map.get(other);
        	if(list == null) {
        		continue;
        	}else if(other == value){
        		if(list.size() == 1) {
        			continue;
        		}else {
        			int first = list.get(0);
        			int second = list.get(1);
        			return first<second?new int[]{first+1, second+1}:new int[]{second+1, first+1};
        		}
        	}else {
        		int first = map.get(value).get(0);
        		int second = map.get(other).get(0);
        		return first<second?new int[]{first+1, second+1}:new int[]{second+1, first+1};
        	}
        }
		return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
