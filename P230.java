
/*
 * 230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
more hint
*/
public class P230 {
	//用成员变量吧....
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{k};
        return search(root, count).val;
    }
	
    public TreeNode search(TreeNode root, int[] count) {
    	if(root==null) return null;
    	TreeNode node = search(root.left, count);
    	if(node != null) return node;
    	if(count[0]==1) return root;
    	count[0]--;
    	return search(root.right, count);
    }
    
    public static void test(Integer a) {
    	a--;
    }
    
	public static void main(String[] args) {
//		P230 p = new P230();
//		System.out.println(p.kthSmallest(new TreeNode(new Integer[]{2,1}, 0), 2));
	}

}
