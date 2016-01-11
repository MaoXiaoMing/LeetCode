
/*
 * 129. Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * 
 * */
public class P129 {
    public static int sumNumbers(TreeNode root) {
    	if(root == null) return 0;
    	else if(root.right==null && root.left==null) return root.val;
    	StringBuilder sb = new StringBuilder();
    	sb.append(root.val);
    	int result = 0;
    	if(root.left != null) {
    		result += sumNumbers(root.left, sb);
    	}
    	if(root.right != null) {
    		result += sumNumbers(root.right, sb);
    	}
    	return result;
    }
    
    public static int sumNumbers(TreeNode root, StringBuilder sb) {
    	if(root.left==null && root.right==null) {
    		int result = Integer.parseInt(sb.append(root.val).toString());
    		sb.deleteCharAt(sb.length()-1);
    		return result;
    	}
    	int result = 0;
    	if(root.left != null) {
    		sb.append(root.val);
    		result += sumNumbers(root.left, sb);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	if(root.right != null) {
    		sb.append(root.val);
    		result += sumNumbers(root.right, sb);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(sumNumbers(new TreeNode(new Integer[]{1, null, 3}, 0)));
    }
}
