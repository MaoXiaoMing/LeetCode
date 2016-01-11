
/*
 * 25. Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class P025 {
	
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while(current!=null) {
        	length++;
        	current = current.next;
        }
        length = length-length%k;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        current = head;
        for(int i=0; i<length/k; i++) {
        	ListNode first = current;
        	ListNode temp = null;
        	int count = k;
        	while(count > 0) {
        		temp = current.next;
        		current.next = pre.next;
        		pre.next = current;
        		current = temp;
        		count--;
        	}
        	first.next = current;
        	pre = first;
        }
       return dummy.next;
    }
    
	public static void main(String[] args) {
		new P025().reverseKGroup(new ListNode(new int[]{1,2,3,4}), 2);
	}

}
