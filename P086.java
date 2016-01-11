
/*
 * 86. Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
public class P086 {
	
    public static ListNode partition(ListNode head, int x) {
    	ListNode sentinal = new ListNode(0);
    	sentinal.next = head;
        ListNode current1 = sentinal;
        ListNode large = new ListNode(0);
        ListNode current2 = large;
        while(current1.next != null) {
        	if(current1.next.val >= x) {
        		current2.next = current1.next;
        		current1.next = current1.next.next;
        		current2 = current2.next;
        	}else current1 = current1.next;
        }
        current2.next = null;
        current1.next = large.next;
        return sentinal.next;
    }
    
	public static void main(String[] args) {
		partition(new ListNode(new int[]{1,4,3,1}), 2);
	}

}
