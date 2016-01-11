
/*
 * 142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
public class P142 {

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null&&fast!=slow) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        if(fast==null || fast.next==null) return null;
        int count = 1;
        ListNode record = slow;
        slow = slow.next;
        while(record != slow) {
        	count++;
        	slow = slow.next;
        } 
        fast = head;
        while(count > 0) {
        	fast = fast.next;
        	count--;
        }
        slow = head;
        while(slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
	
	public static void main(String[] args) {
		P142 p = new P142();
		p.detectCycle(new ListNode(new int[]{1,2,3,4,5}));
	}

}
