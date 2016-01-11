import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 18. 4Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    */

public class P018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
        	if(nums[i]<<2 > target) return res;
        	for(int j=i+1; j<nums.length-2; j++) {
        		if(nums[j]*3 > target-nums[i]) break;
        		int outSum = nums[i]+nums[j];
        		int low = j+1; 
        		int high = nums.length-1;
        		while(low < high) {
        			int sum = outSum+nums[low]+nums[high];
        			if(sum==target) {
        				res.add(Arrays.asList(nums[i],nums[j], nums[low], nums[high]));
        				while(++low<high && nums[low-1]==nums[low]) continue;
        				while(--high>low && nums[high]==nums[high+1]) continue;
        			}
        			else if(sum>target) high--;
        			else low++;
        		}
        		while(j<nums.length-2 && nums[j+1]==nums[j]) j++;
        	}
        	while(i<nums.length-1 && nums[i+1]==nums[i]) i++;
        }
        return res;
    }
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//    	List<List<Integer>> res = new ArrayList<>();
//    	Arrays.sort(nums);
//    	for(int i=0; i<nums.length-3; i++) {
//    		if(nums[i]<<2 > target) return res;
//    		List<List<Integer>> subset = threeSum(nums, i, target-nums[i]);
//    		if(subset == null) continue;
//    		for(List<Integer> l : subset) 
//    			l.add(0, nums[i]);
//    		res.addAll(subset);
//    	}
//    	return res;
//    }
//	
//    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i=start+1; i<nums.length-2; i++) {
//        	if(nums[i]*3 > target) return res;
//        	List<List<Integer>> list = exist(nums, i, target-nums[i]);
//        	if(list == null) continue;
//        	for(List<Integer> l : list) 
//        		l.add(0, nums[i]);
//        	res.addAll(list);
//        	while(i<nums.length-2 && nums[i]==nums[i+1]) {
//        		i++;
//        	}
//        }
//        return res;
//    }
//    
//    public List<List<Integer>> exist(int[] nums, int start, int target) {
//		Set<Integer> set = new HashSet<>();
//		List<List<Integer>> list = new ArrayList<List<Integer>>();
//		for(int i=start+1; i<nums.length; i++) {
//			if(nums[i]<<1 > target) return list;
//			if(set.contains(target-nums[i])) {
//				List<Integer> t = new ArrayList<Integer>();
//				t.add(target-nums[i]);
//				t.add(nums[i]);
//				list.add(t);
//				while(i<nums.length-1 && nums[i]==nums[i+1]) {
//					i++;
//				}
//			}else {
//				set.add(nums[i]);
//			}
//		}
//		return list;
//	}
    
    public void print(List<List<Integer>> lists) {
    	for(List<Integer> l : lists) {
    		for(int i=0; i<l.size(); i++) {
    			System.out.print(l.get(i)+" ");
    		}
    		System.out.println();
    	}
    }
    
	public static void main(String[] args) {
		int[] input = new int[]{-483,-476,-475,-460,-450,-431,-428,-419,-410,-374,-347,-345,-311,-303,-299,-286,-278,-271,-260,-257,-240,-227,-217,-203,-196,-191,-189,-179,-171,-151,-150,-144,-134,-130,-112,-107,-97,-96,-94,-70,-62,-54,-38,-38,-23,-12,-11,-2,2,4,30,33,38,51,51,54,69,90,108,111,112,112,121,129,163,182,184,194,198,199,210,228,229,232,236,237,249,249,259,282,303,312,317,329,329,342,349,368,375,380,384,393,420,433,441,446,460,474,497};
		P018 p = new P018();
		p.print(p.fourSum(input, -2306));
	}

}
