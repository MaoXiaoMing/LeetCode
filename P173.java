import java.util.Stack;

/*
 * 173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
public class P173 {
	private Stack<TreeNode> ancestors = new Stack<>();
	
	public P173(TreeNode root) {
		if(root==null) return ;
		ancestors.push(root);
		TreeNode top = root;
		while(top.left != null) {
			ancestors.push(top.left);
			top = top.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(ancestors.isEmpty()) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = ancestors.pop();
        int result = top.val;
        if(top.right != null) {
        	ancestors.push(top.right);	
        	top = top.right;
            while(top.left != null) {
            	ancestors.push(top.left);
            	top = top.left;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {

	}

}
