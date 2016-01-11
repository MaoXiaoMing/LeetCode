
/*
 * 116. Populating Next Right Pointers in Each Node
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
*/

class TreeLinkNode {
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	int label;
	
	TreeLinkNode(Integer[] nums, int index) {
		if(nums==null || nums.length==0 || nums[index] == null) return ;
		this.label = nums[index];
		if(2*index+1 < nums.length){
			if(nums[index*2+1] != null) {
				this.left = new TreeLinkNode(nums, 2*index+1);
			}else {
				this.left = null;
			}
		}
		if(2*index+2 < nums.length){
			if(nums[index*2+2] != null) {
				this.right = new TreeLinkNode(nums, 2*index+2);
			}else {
				this.right = null;
			}
		}
	}
	
	TreeLinkNode(int val) {
		this.label = val;
	}
}

public class P116 {
	
	public void connect(TreeLinkNode root) {
        if(root==null) return ;
        root.next = null;
        recursion(root);
    }
	
	public void recursion(TreeLinkNode node) {
		if(node==null || (node.left==null && node.right==null))
            return;
		node.left.next=node.right;
		if(node.next != null) 
			node.right.next = node.next.left;
		else 
			node.right.next = null;
		recursion(node.left);
		recursion(node.right);
	}
	
	public static void main(String[] args) {
		
	}

}
