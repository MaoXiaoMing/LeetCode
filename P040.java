import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 40. Combination Sum II
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, 鈥� , ak) must be in non-descending order. (ie, a1 鈮� a2 鈮� 鈥� 鈮� ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 * */

public class P040 {
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void dfs(int[] candidates, int target, int index, List<Integer> inter, List<List<Integer>> res) {
    	if(target == 0) {
    		List<Integer> list = new ArrayList<>();
    		list.addAll(inter);
    		res.add(list);
    		return ;
    	}
    	int pre = -1;
    	for(int i=index; i<candidates.length; i++) {
    		if(pre == candidates[i]) continue;
    		if(candidates[i] <= target) {
    			pre = candidates[i];
    			inter.add(candidates[i]);
    			dfs(candidates, target-candidates[i], i+1, inter, res);
    			inter.remove(inter.size()-1);
    		}else {
    			return ;
    		}
    	}
    }
    
	public static void main(String[] args) {
		P040 p = new P040();
//		List<List<Integer>> res = p.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
		System.out.println();
	}

}
