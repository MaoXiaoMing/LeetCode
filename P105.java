
/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class P105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
	
    public TreeNode build(int[] preorder, int startP, int endP,
    		int[] inorder, int startI, int endI) {
    	if(startP > endP) return null;
    	TreeNode root = new TreeNode(preorder[startP]);
    	int index = startI;
    	for( ; index<=endI; index++) if(inorder[index] == preorder[startP]) break;
    	root.left = build(preorder, startP+1, startP+index-startI,
    			inorder, startI, index-1);
    	root.right = build(preorder, startP+index-startI+1, endP,
    			inorder, index+1, endI);
    	return root;
    }
    
	public static void main(String[] args) {

	}

}
