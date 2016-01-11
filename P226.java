
/*
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

public class P226 {
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null) {
        	return null;
        }else {
        	TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
            return root;
        }
    } 
}
