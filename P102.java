import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/
public class P102 {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if(root==null) return result;
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		List<TreeNode> level = new ArrayList<TreeNode>();
    		List<Integer> list = new ArrayList<Integer>();
    		while(!queue.isEmpty()) {
    			level.add(queue.poll());
    			list.add(level.get(level.size()-1).val);
    		}
    		result.add(list);
    		for(int i=0; i<list.size(); i++) {
    			if(level.get(i).left!=null) queue.add(level.get(i).left);
    			if(level.get(i).right!=null) queue.add(level.get(i).right);
    		}
    	}
    	return result;
    }
    
	public static void main(String[] args) {

	}

}
