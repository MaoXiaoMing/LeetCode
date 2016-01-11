import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class P039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();
        dfs(candidates, 0, target, res, inter);
        return res;
    }
	
    public void dfs(int[] candidates, int index, int last, List<List<Integer>> res,
    		List<Integer> inter) {
    	if(last == 0) {
    		List<Integer> temp = new ArrayList<Integer>();
    		temp.addAll(inter);
    		res.add(temp);
    		return ;
    	}
    	for(int i=index; i<candidates.length; i++) {
    		if(candidates[i] > last) return ;
    		inter.add(candidates[i]);
    		dfs(candidates, i, last-candidates[i], res, inter);
    		inter.remove(inter.size()-1);
    	}
    }
    
	public static void main(String[] args) {

	}

}
