import java.util.Stack;

public class P297 {

    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val+"|"+serialize(root.left)+"|"+serialize(root.right);
    }
	
    public TreeNode deserialize(String data) {
    	return null;
    }
	
	public static void main(String[] args) {
		P297 p = new P297();
		String s = p.serialize(new TreeNode(new Integer[]{1,2,3}, 0));
		System.out.println(s);
		TreeNode root = p.deserialize(s);
		System.out.println();
	}

}
