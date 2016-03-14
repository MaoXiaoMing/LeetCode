import java.util.Arrays;
import java.util.Comparator;

class Pair {
	int val;
	int index;
	
	Pair(int val, int index) {
		this.val = val;
		this.index = index;
	}
}

public class P220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length<2 || t<0 || k<1) return false;
		int length = nums.length;
		Pair[] array = new Pair[length];
		for(int i=0; i<length; i++) {
			array[i] = new Pair(nums[i], i);
		}
		Arrays.sort(array, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.val-p2.val;
			}
		});
		for(int i=0; i<length-1; i++) {
			for(int j=i+1; j<length && Math.abs((long)array[j].val - (long)array[i].val) <= (long)t; j++) {
			//for(int j=i+1; j<length && j-i<=t; j++) {	
				if(Math.abs(array[i].index-array[j].index)<=k)
					return true;
			}
		}
		return false;
    }
}