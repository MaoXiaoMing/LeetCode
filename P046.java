import java.util.ArrayList;
import java.util.List;

public class P046 {
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();
        dfs(nums, inter, res);
        return res;
    }
    
    public void dfs(int[] nums, List<Integer> inter, List<List<Integer>> res) {
    	if(inter.size() == nums.length) {
    		List<Integer> list = new ArrayList<>();
    		list.addAll(inter);
    		res.add(list);
    	}
    	for(int num : nums) {
    		if(!inter.contains(num)) {
    			inter.add(num);
    			dfs(nums, inter, res);
    			inter.remove(inter.size()-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		new P046().permute(new int[]{1});
	}

}
