
public class P082 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode current = sentinal;
        while(current!=null && current.next!=null && current.next.next!=null) {
        	if(current.next.val == current.next.next.val) {
        		ListNode index = current.next.next.next;
        		while(index!=null && index.val==current.next.val) {
        			index = index.next;
        		}
        		current.next = index;
        	}else {
        		current = current.next;
        	}
        }
        return sentinal.next;
    }	
	
	public static void main(String[] args) {

	}

}
