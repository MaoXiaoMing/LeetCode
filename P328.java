
/*
 * 328. Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
*/
public class P328 {

	 public ListNode oddEvenList(ListNode head) {
		 if(head==null || head.next==null || head.next.next==null) return head;
		 ListNode oddPre = head;
		 ListNode current = head.next.next;
		 ListNode evenPre = head.next;
		 while(current!=null) {
			 ListNode temp = current.next;
			 current.next = oddPre.next;
			 oddPre.next = current;
			 oddPre = oddPre.next;
			 evenPre.next = temp;
			 evenPre = evenPre.next;
			 if(evenPre!=null) current = evenPre.next;
			 else current = null;
		 }
		 return head;
	 }
	
	public static void main(String[] args) {
		P328 test = new P328();
		test.oddEvenList(new ListNode(new int[]{8,6,34,53,63,4,35,2,2,4}));
	}

}
