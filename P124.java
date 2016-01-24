
public class P124 {
	private int max;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        max = root.val;
        int value = maxValue(root);
        return max>value?max:value;
    }
	
    public int maxValue(TreeNode root) {
    	if(root==null) return 0;
    	if(root.left==null && root.right==null) {
    		max = Math.max(max, root.val);
    		return root.val;
    	}
    	int leftValue = maxValue(root.left);
    	int rightValue = maxValue(root.right);
    	max = Math.max(max, root.val+leftValue+rightValue);
    	int res = root.val;
    	if(leftValue>rightValue) {
    		res = res>root.val+leftValue?res:root.val+leftValue;
    	}else{
    		res = res>root.val+rightValue?res:root.val+rightValue;
    	}
		max = Math.max(max, res);
		return res;
    }
    
	public static void main(String[] args) {

	}

}
