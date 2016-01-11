
/*Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * */

public class P148 {

    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode first = head;
        ListNode second = head.next;
        while(second.next!=null && second.next.next!=null) {
        	first = first.next;
        	second = second.next.next;
        }
        second = first.next;
        first.next = null;
        first = sortList(head);
        second = sortList(second);
        return mergeTwoLists(first, second);
    }
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;
        while(l1!=null && l2!=null) {
        	if(l1.val < l2.val) {
        		current.next = l1;
        		l1 = l1.next;
        	}else {
        		current.next = l2;
        		l2 = l2.next;
        	}
        	current = current.next;
        }
        current.next = l1==null?l2:l1;
        return sentinel.next;  
    }
    
	public static void main(String[] args) {
		sortList(new ListNode(new int[]{1,4,2,1}));
	}

}
