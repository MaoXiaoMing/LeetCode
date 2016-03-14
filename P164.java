import java.util.ArrayList;
import java.util.List;

public class P164 {
	public int maximumGap(int[] nums) {
		if(nums==null || nums.length<2) return 0;
		int max, min;
		max = min = nums[0];
		for(int i=1; i<nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		if(max==min) return 0;
		double div = max-min;
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int i=0; i<buckets.length; i++) buckets[i] = new ArrayList<Integer>();
//		for(List bucket : buckets) bucket = new ArrayList<Integer>();
		for(int num : nums) {
			buckets[(int)(((num-min)/div)*nums.length)].add(num);
		}
		for(List bucket : buckets) bucket.sort(null);
		boolean first = true;
		int pre = 0;
		max = 0;
		for(List<Integer> bucket : buckets) {
			for(int num : bucket) {
				if(first) {
					pre = num; 
					first = false;
				}
				else {
					max = Math.max(max, num-pre);
					pre = num;
				}
			}
		}
		return max;
    }
}