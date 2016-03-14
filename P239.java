import java.util.Deque;
import java.util.LinkedList;

public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums==null || nums.length==0) return new int[0];
    	int[] res = new int[nums.length-k+1];
    	Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<k; i++) {
        	while(queue.size()!=0 && nums[i]>nums[queue.getLast()])
        		queue.removeLast();
        	queue.addLast(i);
        }
        
        for(int i=k; i<nums.length; i++) {
        	res[i-k] = nums[queue.getFirst()];
        	while(queue.size()!=0 && nums[i]>nums[queue.getLast()])
        		queue.removeLast();
        	if(queue.size()!=0 && queue.getFirst()+k<=i)
        		queue.removeFirst();
        	queue.addLast(i);
        }
        res[nums.length-k] = nums[queue.getFirst()];
        return res;
    }
    
	public static void main(String[] args) {
		P239 test = new P239();
		test.maxSlidingWindow(new int[]{3,3,5,5,6,7}, 3);
	}

}
