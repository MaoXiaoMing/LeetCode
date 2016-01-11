import java.util.ArrayList;
import java.util.List;

public class P109 {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current != null) {
        	list.add(current.val);
        	current = current.next;
        }
        Integer[] nums = list.toArray(new Integer[0]);
        if(nums==null || nums.length == 0) return null;
    	return convert(nums, 0, nums.length-1);
    }
    
    public TreeNode convert(Integer[] nums, int start, int end) {
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
