import java.util.ArrayList;
import java.util.List;

/*
 * Summary Ranges
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].*/
public class P228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		int start = 0;
		int end = 0;
		for(int i=0; i<nums.length-1; i++) {
        	if(nums[i]== nums[i+1]-1) {
        		end ++;
        	}else {
        		if(start==end) {
        			res.add(String.valueOf(nums[start]));
        		}else {
        			res.add(nums[start]+"->"+nums[end]);
        		}
        		start = end = i+1;
        	}
        }
        if(start == nums.length-1) {
        	res.add(String.valueOf(nums[nums.length-1]));
        }else {
        	res.add(nums[start]+"->"+nums[end]);
        }
        return res;
    }
	
	public static void display(List<String> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void main(String[] args) {
		display(new P228().summaryRanges(new int[]{0,1,2,4,5,7}));
	}
}
