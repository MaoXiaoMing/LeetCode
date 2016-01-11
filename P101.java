/*
 * Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3

 * 
 * */
public class P101 {
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left==null && right==null) return true;
		if(left==null || right==null) return false;
		if(left.val != right.val) return false;
		return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
	}
	
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        else return isSymmetric(root.left, root.right);
    }
    
	public static void main(String[] args) {

	}

}
