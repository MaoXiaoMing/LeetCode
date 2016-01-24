
public class ListNode {
	
	public ListNode(int[] arrays) {
		if (arrays==null || arrays.length==0) {
			next = null;
		}else {
			this.val = arrays[0];
			ListNode current = this;
			for(int i=0; i<arrays.length-1; i++) {
				current.next = new ListNode(arrays[i+1]);
				current = current.next;
			}
		}
	}
	
	public void displayList() {
		ListNode p = this;
		while(p!=null) {
			System.out.print(p.val+"\t");
			p = p.next;
		}
	}
	
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(new int[]{1,0,1});
		head.displayList();
	}
	
}
