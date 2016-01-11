
/*
 * Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Subscribe to see which companies asked this question*/

public class P234 {
	
	public ListNode reverse(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode current = head.next;
		head.next = null;
		while(current != null) {
			ListNode tmp = current.next;
			current.next = head;
			head = current;
			current = tmp;
		}
		return head;
	}
	
	public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        if(p1 == null) {
        	return true;
        }
        while(p2.next!=null && p2.next.next!=null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        p2 = head;
        p1 = p1.next;
        p1 = reverse(p1);
        while(p1 != null) {
        	if(p1.val != p2.val) {
        		return false;
        	}else {
        		p1 = p1.next;
        		p2 = p2.next;
        	}
        }
        return true;
		/*ListNode re = reverse(head);
		while(head != null) {
			if(head.val != re.val) {
				return false;
			}else {
				head = head.next;
				re = re.next;
			}
		}
		return true;*/
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(new int[]{1,2,2,1});
		System.out.println(new P234().isPalindrome(head));
	}
}
