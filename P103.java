import java.util.ArrayList;
import java.util.List;

public class P103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        boolean direction = true;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()) {
        	List<Integer> temp = new ArrayList<>();
        	List<TreeNode> next = new ArrayList<>();
        	if(direction) {
        		for(int i=level.size()-1; i>=0; i--) {
        			TreeNode node = level.get(i);
        			temp.add(node.val);
        			if(node.left!=null) next.add(node.left);
        			if(node.right!=null) next.add(node.right);
        		}
        	}else {
        		for(int i=level.size()-1; i>=0; i--) {
        			TreeNode node = level.get(i);
        			temp.add(node.val);
        			if(node.right!=null) next.add(node.right);
        			if(node.left!=null) next.add(node.left);
        		}
        	}
        	direction = !direction;
        	res.add(temp);
        	level.clear();
        	level.addAll(next);
        }
        return res;
    }	
	
	public static void main(String[] args) {
		new P103().zigzagLevelOrder(new TreeNode(new Integer[]{1,2,3}, 0));
	}

}
