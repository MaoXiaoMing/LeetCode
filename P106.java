
public class P106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder.length==0) return null;
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
	
    public TreeNode build(int[] inorder, int startI, int endI,
    		int[] postorder, int startP, int endP) {
    	if(startP > endP) return null;
    	TreeNode root = new TreeNode(postorder[endP]);
    	int index = startI;
    	for( ; index<=endI; index++) if(inorder[index] == postorder[endP]) break;
    	root.left = build(inorder, startI, index-1,
    			postorder, startP, startP+index-startI-1);
    	root.right = build(inorder, index+1, endI,
    			postorder, startP+index-startI, endP-1);
    	return root;
    }
    
	public static void main(String[] args) {

	}

}
