
/*
 * Reverse Linked List
 * Reverse a singly linked list.*/

public class P206 {
	public static ListNode reverseList(ListNode head) {
        if(head == null) {
        	return null;
        }else {
        	ListNode current = head.next;
        	head.next = null;
        	while(current != null) {
        		ListNode temp = current.next;
        		current.next = head;
        		head = current;
        		current = temp;
        	}
        	return head;
        }
    }
	
	public static void main(String[] args) {
		ListNode list = new ListNode(new int[]{1,2,3,4,5});
		list.displayList();
		list = reverseList(list);
		list.displayList();
	}
}
