import java.util.ArrayList;
import java.util.List;

/*
 * 216. Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public class P216 {
	
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();
        dfs(res, inter, k, n, 1);
        return res;
    }
	
    public void dfs(List<List<Integer>> res, List<Integer> inter, int k, int n, int start) {
    	if(k==0&&n==0) {
    		res.add(new ArrayList<>(inter));
    		return ;
    	}
    	for(int i=start; i<=9; i++) {
    		if(n<start) return ;
    		inter.add(i);
    		dfs(res, inter, k-1, n-i, i+1);
    		inter.remove(inter.size()-1);
    	}
    }
    
	public static void main(String[] args) {

	}

}
