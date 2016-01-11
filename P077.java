import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * */
public class P077 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> inter = new HashSet<Integer>();
        dfs(res, inter, n, k, 1);
        return res;
    }
	
    public static void dfs(List<List<Integer>> res, Set<Integer> inter, int n, int k, int start) {
    	if(inter.size() == k) {
    		res.add(new ArrayList<>(inter));
    		return ;
    	}
    	for(int i=start; i<=n; i++) {
    		if(n-start+1 < k-inter.size()) return ;
    		inter.add(i);
    		dfs(res, inter, n, k, i+1);
    		inter.remove(i);
    	}
    }
    
	public static void main(String[] args) {
		combine(4, 2);
	}

}
