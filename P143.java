import java.awt.List;

/*
 * 143. Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
public class P143 {

    public void reorderList(ListNode head) {
    	if(head==null || head.next==null) return ;
    	ListNode mid = head;
    	ListNode last = head.next;
    	while(last!=null && last.next!=null) {
    		mid = mid.next;
    		last = last.next.next;
    	}
    	ListNode pre = mid;
    	ListNode current = mid.next;
    	pre.next = null;
    	while(current!=null) {
    		ListNode temp = current.next;
    		current.next = pre.next;
    		pre.next = current;
    		current = temp;
    	}
    	ListNode list1 = head;
    	ListNode list2 = mid.next;
    	mid.next = null;
    	while(list2!=null) {
    		ListNode temp = list2.next;
    		list2.next = list1.next;
    		list1.next = list2;
    		list1 = list1.next.next;
    		list2 = temp;
    	}
    }
	
	public static void main(String[] args) {
		P143 p = new P143();
		p.reorderList(new ListNode(new int[]{1,2,3}));
	}

}
