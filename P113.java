import java.util.ArrayList;
import java.util.List;

public class P113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();
        search(res, inter, root, sum);
        return res;
    }
	
    public void search(List<List<Integer>> res, List<Integer> inter,
    		TreeNode root, int sum) {
    	if(root == null) return ;
    	else if(root.val==sum && root.left==null && root.right==null) {
    		inter.add(root.val);
    		res.add(new ArrayList<>(inter));
    		inter.remove(inter.size()-1);
    		return ;
    	}
    	if(root.left != null) {
    		inter.add(root.val);
    		search(res, inter, root.left, sum-root.val);
    		inter.remove(inter.size()-1);
    	}
    	if(root.right != null) {
    		inter.add(root.val);
    		search(res, inter, root.right, sum-root.val);
    		inter.remove(inter.size()-1);
    	}
    }
    
	public static void main(String[] args) {

	}

}
