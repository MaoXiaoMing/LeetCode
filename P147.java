
/*
 * Insertion Sort List
 * Sort a linked list using insertion sort.
 * */

public class P147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        for(ListNode current=head; current!=null; ) {
        	ListNode index = res;
        	while(index.next!=null && index.next.val<current.val) {
        		index = index.next;
        	}
        	ListNode temp = current.next;
        	current.next = index.next;
        	index.next = current.next;
        	current = temp;
        }
        return res.next;
    }
	
	public static void main(String[] args) {

	}

}
