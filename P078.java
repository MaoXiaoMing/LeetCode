import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res; 
        Arrays.sort(nums);
        List<Integer> inter = new ArrayList<>();
        dfs(nums, res, inter, 0);
        return res;
    }
	
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> inter, int start) {
    	if(start == nums.length) {
    		res.add(new ArrayList<Integer>(inter));
    		return ;
    	}
    	inter.add(nums[start]);
    	dfs(nums, res, inter, start+1);
    	inter.remove(inter.size()-1);
    	dfs(nums, res, inter, start+1);
    }
    
	public static void main(String[] args) {
		new P078().subsets(new int[]{0,1});
	}

}
