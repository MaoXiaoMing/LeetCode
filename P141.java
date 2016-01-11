
/*
 * 141. Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 * */

public class P141 {
	
    public boolean hasCycle(ListNode head) {
    	if(head==null || head.next==null) return false;
        ListNode pre = head.next;
        ListNode after = head;
        while(pre!=null && pre.next!=null) {
        	if(pre == after) return true;
        	else {
        		pre = pre.next.next;
        		after = after.next;
        	}
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
