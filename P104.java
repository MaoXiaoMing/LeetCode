/*
 * Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * */
public class P104 {
	
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return Math.max(maxDepth(root.right), maxDepth(root.left))+1;
    }
    
	public static void main(String[] args) {

	}

}
