import java.util.ArrayList;
import java.util.List;

/*
 * 94. Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
 * */

public class P094 {
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> res) {
    	if(root == null) return ;
    	inorderTraversal(root.left, res);
    	res.add(root.val);
    	inorderTraversal(root.right, res);
    }
    
	public static void main(String[] args) {

	}

}
