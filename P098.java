import java.util.ArrayList;
import java.util.List;

/*
 * 98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
public class P098 {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        for(int i=1; i<list.size(); i++) {
        	if(list.get(i-1)>=list.get(i)) return false;
        }
        return true;
    }
	
    public void inorder(List<Integer> list, TreeNode root) {
    	if(root==null) return;
    	inorder(list, root.left);
    	list.add(root.val);
    	inorder(list, root.right);
    }
    
	public static void main(String[] args) {
		new P098().isValidBST(new TreeNode(new Integer[]{10,5,15,null,null,6,20}, 0));
	}

}
