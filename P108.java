
public class P108 {
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums==null || nums.length == 0) return null;
    	return convert(nums, 0, nums.length-1);
    }
    
    public TreeNode convert(int[] nums, int start, int end) {
    	if(start > end) return null;
    	int mid = (start+end)/2;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = convert(nums, start, mid-1);
    	node.right = convert(nums, mid+1, end);
    	return node;
    }
    
	public static void main(String[] args) {

	}

}
