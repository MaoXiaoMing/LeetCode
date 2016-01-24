
public class TreeNode {
	TreeNode(Integer[] nums, int index) {
		if(nums==null || nums.length==0 || nums[index] == null) return ;
		this.val = nums[index];
		if(2*index+1 < nums.length){
			if(nums[index*2+1] != null) {
				this.left = new TreeNode(nums, 2*index+1);
			}else {
				this.left = null;
			}
		}
		if(2*index+2 < nums.length){
			if(nums[index*2+2] != null) {
				this.right = new TreeNode(nums, 2*index+2);
			}else {
				this.right = null;
			}
		}
	}

	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
