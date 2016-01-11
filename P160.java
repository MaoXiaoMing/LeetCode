
/*
 * Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                                                           ¨K
                     c1 ¡ú c2 ¡ú c3
                                                           ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

public class P160 {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
		}
        int lengthA = 0;
        int lengthB = 0;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != null) {
        	lengthA ++;
        	node1 = node1.next;
        }
        while(node2 != null) {
        	lengthB ++;
        	node2 = node2.next;
        }
        int step = lengthA - lengthB;
        if(step == 0) {
        	node1 = headA;
        	node2 = headB;
        }else if(step > 0) {
        	node1 = headA;
        	while(step > 0) {
        		node1 = node1.next;
        		step --;
        	}
        	node2 = headB;
        }else {
        	node2 = headB;
        	while(step < 0) {
        		node2 = node2.next;
        		step++;
        	}
        	node1 = headA;
        }
        while(node1!=null && node2!=null) {
    		if(node1 == node2) {
    			return node1;
    		}
    		node1 = node1.next;
    		node2 = node2.next;
    	}
    	return null;
    }
	
	public static void main(String[] args) {
		getIntersectionNode(null, null);
	}
}
