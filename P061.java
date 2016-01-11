/*
61. Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
public class P061 {
	
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null) return null;
        int length = 1;
        ListNode current = head;
        while(current.next != null) {
        	length++;
        	current = current.next;
        }
        int last = k%length;
        if(last == 0) return head;
        length -= last;
        ListNode l = head;
        while(length > 1) {
        	l = l.next;
        	length--;
        }
        current.next = head;
        head = l.next;
        l.next = null;
        return head;
    }
	
	public static void main(String[] args) {
		
	}
}
