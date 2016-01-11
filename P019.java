
/*
 * Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

public class P019 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0); 
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode current = sentinel;
        while(n > 0) {
        	current = current.next;
        	n--;
        }
        if(current == null) {
        	prev.next = prev.next.next;
        	return sentinel.next;
        }
        while(current.next != null) {
        	prev = prev.next;
        	current = current.next;
        }
        prev.next = prev.next.next;
        return head;
    }
	
	public static void main(String[] args) {

	}

}
