
public class P024 {

    public static ListNode swapPairs(ListNode head) {
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode current = sentinal;
        while(current.next!=null && current.next.next!=null) {
        	ListNode next = current.next;
        	current.next = current.next.next;
        	next.next = current.next.next;
        	current.next.next = next;
        	current = next;
        }
        return sentinal.next;
    }
	
	public static void main(String[] args) {
		swapPairs(new ListNode(new int[]{1,2,3,4}));
	}

}
