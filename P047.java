import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public class P047 {
	
	private Map<Integer, Integer> count = new HashMap<>();
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums == null) return res;
    	for(int i=0; i<nums.length; i++) {
    		if(!count.containsKey(nums[i])) count.put(nums[i], 1);
    		else count.put(nums[i], count.get(nums[i])+1);
    	}
        List<Integer> inter = new ArrayList<>();
        Map<Integer, Integer> appear = new HashMap<>();
        for(int num : count.keySet()) {
        	appear.put(num, 0);
        }
        dfs(count, inter, appear, res, nums.length);
        return res;
    }
    
    public void dfs(Map<Integer, Integer> count, List<Integer> inter, 
    		Map<Integer, Integer> appear, List<List<Integer>> res,
    		int length) {
    	if(inter.size() == length) {
    		res.add(new ArrayList<Integer>(inter));
    		return ;
    	}
    	for(int num : count.keySet()) {
    		if(appear.get(num) < count.get(num)) {
    			appear.put(num, appear.get(num)+1);
    			inter.add(num);
    			dfs(count, inter, appear, res, length);
    			inter.remove(inter.size()-1);
    			appear.put(num, appear.get(num)-1);
    		}
    	}
    }
    
	public static void main(String[] args) {

	}

}
