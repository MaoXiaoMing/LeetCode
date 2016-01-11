
public class P114 {

    public void flatten(TreeNode root) {
        recursion(root);
    }	
	
    public TreeNode recursion(TreeNode root) {
    	if(root==null || (root.left==null&&root.right==null)) return root;
    	TreeNode rightLast = recursion(root.right);
    	if(root.left != null) {
    		TreeNode node = recursion(root.left);
    		node.right = root.right;
    		root.right = root.left;
    		root.left = null;
    		if(rightLast == null) return node;
    	}
    	return rightLast;
    }
    
	public static void main(String[] args) {
		new P114().flatten(new TreeNode(new Integer[]{1,2,null,3}, 0));
	}

}
