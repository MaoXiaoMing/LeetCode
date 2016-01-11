/*
 * Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5*/

public class P203 {
	public static ListNode removeElements(ListNode head, int val) {
		while(head != null) {
			if(head.val == val) {
				head = head.next;
			}else {
				break;
			}
		}
		if(head == null) return null;
        ListNode current = head;
		while(current.next != null) {
        	if(current.next.val == val) {
        		current.next = current.next.next;
        	}else {
        		current = current.next;
        	}
        }
		return head;
    }
	
	public static void main(String[] args) {
		ListNode head = removeElements(new ListNode(new int[]{1,2,2,1}), 2);
		head.displayList();
	}
}
