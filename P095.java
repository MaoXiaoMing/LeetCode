import java.util.ArrayList;
import java.util.List;

public class P095 {

    public List<TreeNode> generateTrees(int n) {
    	return recursion(1, n);
    }
	
    public List<TreeNode> recursion(int start, int end) {
    	List<TreeNode> res = new ArrayList<>();
    	if(start>end) return res;
    	if(start==end) {
    		TreeNode node = new TreeNode(start);
    		res.add(node);
    		return res;
    	}
    	for(int i=start; i<=end; i++) {
    		List<TreeNode> leftList = recursion(start, i-1);
    		List<TreeNode> rightList = recursion(i+1, end);
    		if(leftList.size()==0) {
    			for(int j=0; j<rightList.size(); j++) {
    				TreeNode parent = new TreeNode(i);
    				parent.right = rightList.get(j);
    				parent.left = null;
    				res.add(parent);
    			}
    		}else if(rightList.size()==0) {
    			for(int j=0; j<leftList.size(); j++) {
    				TreeNode parent = new TreeNode(i);
    				parent.left = leftList.get(j);
    				parent.right = null;
    				res.add(parent);
    			}
    		}else {
    			for(int j=0; j<leftList.size(); j++) {
        			for(int k=0; k<rightList.size(); k++) {
        				TreeNode parent = new TreeNode(i);
        				parent.left = leftList.get(j);
        				parent.right = rightList.get(k);
        				res.add(parent);
        			}
        		}
    		}
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		new P095().generateTrees(2);
	}

}
