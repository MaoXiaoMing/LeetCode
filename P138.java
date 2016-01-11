
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
	RandomListNode(int[] nums, int index) {
		if(index >= nums.length) return ;
		this.label = nums[index];
		next = new RandomListNode(nums, index+1);
	}
}

public class P138 {
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null) return null;
    	RandomListNode current = head;
    	while(current != null) {
    		RandomListNode temp = new RandomListNode(current.label);
    		temp.next = current.next;
    		current.next = temp;
    		current = temp.next;
    	}
    	current = head;
    	while(current != null) {
    		if(current.random == null) current.next.random = null;
    		else current.next.random = current.random.next;
    		current = current.next.next;
    	}
    	RandomListNode res = head.next;
    	current = res;
    	RandomListNode pre = head;
    	while(current.next != null) {
    		pre.next = pre.next.next;
    		pre = pre.next;
    		current.next = current.next.next;
    		current = current.next;
    	}
    	pre.next = null;
    	return res;
    }
    
    public void test(RandomListNode list) {
    	while(list != null) {
    		System.out.println(list.label);
    		list = list.next;
    	}
    }
    
	public static void main(String[] args) {
		P138 p = new P138();
		RandomListNode list = p.copyRandomList(new RandomListNode(new int[]{1,2,3,4}, 0));
		p.test(list);
	}

}
