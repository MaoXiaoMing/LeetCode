
/*
 * 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
 * */

public class P092 {
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode pre = sentinal;
        int index = 1;
        while(index < m) {
        	pre = pre.next;
        	index++;
        }
        ListNode current = pre.next;
        pre.next = null;
        while(index <= n) {
        	ListNode temp = current.next;
        	current.next = pre.next;
        	pre.next = current;
        	current = temp;
        	index++;
        }
        while(pre.next != null) pre = pre.next;
        pre.next = current;
        return sentinal.next;
    }
    
	public static void main(String[] args) {
		reverseBetween(new ListNode(new int[]{5}), 1, 1);
	}

}
