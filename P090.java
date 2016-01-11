import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P090 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        List<Integer> inter = new ArrayList<>();
        dfs(nums, res, inter, 0);
        return res;
    }
	
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> inter, int start) {
    	res.add(new ArrayList<Integer>(inter));
    	for(int i=start; i<nums.length; i++) {
    		if(i!=start && nums[i]==nums[i-1]) continue;
    		inter.add(nums[i]);
    		dfs(nums, res, inter, i+1);
    		inter.remove(inter.size()-1);
    	}
//    	int prev = -1;
//    	for(int i=start; i<nums.length; i++) {
//    		dfs(nums, res, inter, i+1);
//    		if(prev == nums[i]) continue;
//    		List<Integer> list= new ArrayList<Integer>();
//    		prev = nums[i];
//    		list.add(nums[i]);
//    		dfs(nums, res, new ArrayList<Integer>(list), i+1);
//    	}
    }
    
	public static void main(String[] args) {
		new P090().subsetsWithDup(new int[]{1,2,2});
	}

}
