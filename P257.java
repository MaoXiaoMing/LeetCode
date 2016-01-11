import java.util.ArrayList;
import java.util.List;

/*
 * Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]*/

public class P257 {
	
	public void dfs(TreeNode root, List<String> res, String str) {
		if(root.left != null) {
			String append = str+"->"+root.left.val;
			dfs(root.left, res, append);
		}
		if(root.right != null) {
			String append = str+"->"+root.right.val;
			dfs(root.right, res, append);
		}
		if(root.left==null && root.right==null) {
			res.add(str);
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if(root == null) {
			return res;
		}else {
			dfs(root, res, root.val+"");
		}
		return res;
    }
	
	public static void main(String[] args) {
		
	}

}
