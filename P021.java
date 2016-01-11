
/*
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.*/
public class P021 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;
        while(l1!=null && l2!=null) {
        	if(l1.val < l2.val) {
        		current.next = l1;
        		current = current.next;
        		l1 = l1.next;
        	}else {
        		current.next = l2;
        		current = current.next;
        		l2 = l2.next;
        	}
        }
        if(l1 == null) {
        	current.next = l2;
        }else {
        	current.next = l1;
        }
        return sentinel.next;
    }
	
	public static void main(String[] args) {

	}

}
