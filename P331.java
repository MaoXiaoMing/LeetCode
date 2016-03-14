public class P331 {
    private int count;
	public boolean isValidSerialization(String preorder) {
		count = 0;
		String[] nodes = preorder.split(",");
		if(traversal(nodes)) {
			return count==nodes.length;
		}
		return false;
    }
	
	public boolean traversal(String[] nodes) {
		if(count==nodes.length) return false;
		else if(nodes[count++].equals("#")) return true;
		return traversal(nodes)&&traversal(nodes);
	}
}