
/*
 * Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class P002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode guard1 = new ListNode(0);
    	guard1.next = l1;
    	ListNode guard2 = new ListNode(0);
    	guard2.next = l2;
    	ListNode current1 = guard1;
    	ListNode current2 = guard2;
    	int flag = 0;
    	for( ; current1.next!=null && current2.next!=null; current1=current1.next, current2=current2.next) {
    		current1.next.val += (current2.next.val+flag);
    		flag = current1.next.val/10;
			current1.next.val %= 10;
    	}
    	if(current1.next==null && current2.next==null && flag==1) {
    		current1.next = new ListNode(1);
    		return guard1.next;
    	}else if(current1.next==null) {
    		current1.next = current2.next;
    	}
    	if(flag == 0) return guard1.next;
    	for( ; current1.next!=null; current1=current1.next) {
			current1.next.val++;
    		flag = current1.next.val/10;
			current1.next.val %= 10;
			if(flag == 0) {
				break;
			}
		}
		if(current1.next==null&&flag==1) {
			current1.next = new ListNode(1);
		}
    	return guard1.next;
    }
	
	public static void main(String[] args) {

	}
}

//ListNode current1 = l1;
//ListNode current2 = l2;
//int flag = 0;
//for( ; current1!=null&&current2!=null; current1=current1.next, current2=current2.next) {
//	int sum = l1.val+l2.val+flag;
//	l1.val = sum%10;
//	flag = sum/10;
//}
//if(current2!=null) {
//	current1.next = current2;	
//	while(current1 != null) {
//		
//	}
//}
//while(current1 != null) {
//	current1.val += flag;
//	if(current2.val<10) {
//		return l1;
//	}else {
//		current2.val /= 10;
//		flag = 1;
//		current2 = current2.next;
//	}
//}
//if(flag == 1) {
//	current2.next = new ListNode(1);
//	return l1;
//}
//return l1;
