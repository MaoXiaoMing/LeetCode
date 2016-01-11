import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 144. Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
*/

public class P144 {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return  res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.right!=null) stack.push(node.right);
			if(node.left!=null) stack.push(node.left);
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> res = new P144().preorderTraversal(new TreeNode(new Integer[]{1, null, 2, null, null, 3}, 0));
		for(int re : res) {
			System.out.println(re);
		}
	}

}
