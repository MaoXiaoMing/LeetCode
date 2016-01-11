
/*
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/
public class P111 {
	
	public static int minDepth(TreeNode root) {
        if(root == null ) return 0;
//        else if(root.left!=null && root.right!=null) return 1+Math.min(minDepth(root.left), minDepth(root.right));
//        else return 1+minDepth(root.right)+minDepth(root.left);
        if(root.right==null && root.left==null) return 1;
        if(root.right!=null && root.left!=null) 
        	return Math.min(minDepth(root.left), minDepth(root.right))+1;
        if(root.right != null) {
        	return minDepth(root.right)+1;
        }else{
        	return minDepth(root.left)+1;
        }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(new Integer[]{1, null, 2}, 0);
		System.out.println(minDepth(root));
	}

}
