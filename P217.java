import java.util.HashSet;
import java.util.Set;


/*
 * Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.*/

public class P217 {
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
        	if(set.contains(nums[i])) {
        		return true;
        	}else {
        		set.add(nums[i]);
        	}
        }
        return false;
    }
}
