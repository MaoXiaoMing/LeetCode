import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*199. Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * */
public class P199 {
	
    public static List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root==null) return res;
        List<TreeNode> queue = new ArrayList<>();
        List<TreeNode> dup = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	for(int i=0; i<queue.size()-1; i++) {
        		TreeNode temp = queue.get(i);
        		if(temp.left!=null) dup.add(temp.left);
            	if(temp.right!=null) dup.add(temp.right);
        	}
        	TreeNode temp = queue.get(queue.size()-1);
        	res.add(temp.val);
        	if(temp.left!=null) dup.add(temp.left);
        	if(temp.right!=null) dup.add(temp.right);
        	queue.clear();
        	queue.addAll(dup);
        	dup.clear();
        }
        return res;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(new Integer[]{1, 2}, 0);
		List res = rightSideView(root);
		System.exit(0);
	}

}
