import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class P015 {
	
	public List<List<Integer>> exist(int[] nums, int index, int sum) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=index+1; i<nums.length; i++) {
			if(set.contains(sum-nums[i])) {
				List<Integer> t = new ArrayList<Integer>();
				t.add(nums[index]);
				t.add(sum-nums[i]);
				t.add(nums[i]);
				list.add(t);
				while(i<nums.length-1 && nums[i]==nums[i+1]) {
					i++;
				}
			}else {
				set.add(nums[i]);
			}
		}
		return list;
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
        	List<List<Integer>> list = exist(nums, i, -nums[i]);
        	if(list == null) continue;
        	res.addAll(list);
        	while(i<nums.length-2 && nums[i]==nums[i+1]) {
        		i++;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		P015 p = new P015();
		p.threeSum(new int[]{-1,0,1,2,-1,-4});
	}

}
