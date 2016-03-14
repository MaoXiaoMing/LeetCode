
/*307. Range Sum Query - Mutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.*/

public class P307 {
	
	private Node root;
	
	private class Node {
		int left, right;
		int sum;
		Node leftChild, rightChild;
		
		Node(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}
	}

	private Node createNode(int[] nums, int left, int right) {
		if(left==right) {
			return new Node(left, right, nums[left]);
		}
		Node node = new Node(left, right, 0);
		int mid = (left+right)/2;
		node.leftChild = createNode(nums, left, mid);
		node.rightChild = createNode(nums, mid+1, right);
		node.sum = node.leftChild.sum+node.rightChild.sum;
		return node;
	}
	
    public P307(int[] nums) {
    	if(nums==null || nums.length==0) return;
		root = createNode(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(Node node, int index, int val) {
    	if((node.left==index) && (node.right==index)) {
    		node.sum = val;
    		return ;
    	}
    	int mid = (node.left+node.right)/2;
    	if(index <= mid) update(node.leftChild, index, val);
    	else update(node.rightChild, index, val);
    	node.sum = node.rightChild.sum+node.leftChild.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(Node node, int left, int right) {
    	if(node.left==left && node.right==right) return node.sum;
    	int mid = (node.left+node.right)/2;
    	if(right <=mid) return sumRange(node.leftChild, left, right);
    	else if(left>mid) return sumRange(node.rightChild, left, right);
    	else return sumRange(node.leftChild, left, mid)+sumRange(node.rightChild, mid+1, right);
    }
    
	public static void main(String[] args) {
		P307 test = new P307(new int[]{1,3,5});
		System.out.println(test.sumRange(0, 0));
		test.update(1, 2);
		System.out.println(test.sumRange(0, 2));
	}

}
