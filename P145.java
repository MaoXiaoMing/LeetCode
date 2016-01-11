import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 145. Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
*/

public class P145 {
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode last = null;
        do{
        	while(current != null) {
        		stack.push(current);
        		current = current.left;
        	}
        	last = null;
        	while(!stack.isEmpty()) {
        		current = stack.pop();
        		if(current.right == last) {
        			res.add(current.val);
        			last = current;
        		}else {
        			stack.push(current);
        			current = current.right;
        			break;
        		}
        	}
        }while(!stack.isEmpty());
        return res;
    }
	
	public static void main(String[] args) {

	}

}
