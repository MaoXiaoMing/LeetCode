
/*
 * 222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2^h nodes inclusive at the last level h.
*/
public class P222 {
	
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight == rightHeight) 
        	return (1<<leftHeight)+countNodes(root.right);
        else 
        	return (1<<rightHeight)+countNodes(root.left);
    }
    
    public int height(TreeNode root) {
    	int count = 0;
    	while(root != null) {
    		count++;
    		root = root.left;
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		P222 test = new P222();
		for(int i=1; i<10000; i++) {
			Integer[] input = new Integer[i];
			for(int j=0; j<i; j++) {
				input[j] = i;
			}
			System.out.println(test.countNodes(new TreeNode(input, 0))==input.length);
		}
	}

}
