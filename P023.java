
public class P023 {
	
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists==null || lists.length==0) return null; 
    	return mergeKLists(lists, 0, lists.length-1);
//    	ListNode head = lists[0];
//    	for(int i=1; i<lists.length; i++) {
//    		head = mergetList(head, lists[i]);
//    	}
//    	return head;
    }
    
    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
    	if(start==end) return lists[start];
    	else if (start < end) {
    		 int mid = (end - start) / 2 + start;
    	        ListNode left = mergeKLists(lists, start, mid);
    	        ListNode right = mergeKLists(lists, mid + 1, end);
    	        return mergetList(left, right);
    	}else return null;
    }
    
    public ListNode mergetList(ListNode list1, ListNode list2) {
    	ListNode sentinal = new ListNode(1);
    	ListNode current = sentinal;
    	while(list1!=null && list2!=null) {
    		if(list1.val < list2.val) {
    			current.next = list1;
    			list1 = list1.next;
    		}else {
    			current.next = list2;
    			list2 = list2.next;
    		}
    		current = current.next;
    	}
    	if(list1 == null) current.next = list2;
    	else current.next = list1;
    	return sentinal.next;
    }
    
	public static void main(String[] args) {
		P023 p = new P023();
	}

}
