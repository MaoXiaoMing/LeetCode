import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
public class P107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(root==null) return res;
    	List<TreeNode> preLevel = new ArrayList<TreeNode>();
    	preLevel.add(root);
    	recursion(res, preLevel);
/*        List<List<Integer>> rev = new ArrayList<>();
        if(root == null) return rev;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(level.size() != 0) {
        	List<Integer> list = new ArrayList<>();
        	List<TreeNode> record = new ArrayList<>();
        	for(int i=0; i<level.size(); i++) {
        		TreeNode node = level.get(i);
        		list.add(node.val);
        		if(node.left!=null) record.add(node.left);
        		if(node.right!=null) record.add(node.right);
        	}
        	level.clear();
        	level.addAll(record);
        	rev.add(list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<rev.size(); i++) {
        	res.add(rev.get(rev.size()-1-i));
        }
        return res;*/
    	return res;
    }
	
    public void recursion(List<List<Integer>> res, List<TreeNode> preLevel) {
    	if(preLevel.size() == 0) return ;
    	List<TreeNode> nextLevel = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	for(int i=0; i<preLevel.size(); i++) {
    		TreeNode node = preLevel.get(i);
    		list.add(node.val);
    		if(node.left != null) nextLevel.add(node.left);
    		if(node.right != null) nextLevel.add(node.right);
    	}
    	recursion(res, nextLevel);
    	res.add(list);
    }
    
	public static void main(String[] args) {

	}

}
