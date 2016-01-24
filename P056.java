import java.util.ArrayList;
import java.util.List;

/*
 * 56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class P056 {
	
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals==null || intervals.size()==0) return res;
        sort(intervals, 0, intervals.size()-1);
        Interval pre = intervals.get(0);
        res.add(pre);
        for(int i=1; i<intervals.size(); i++) {
        	if(pre.end >= intervals.get(i).start) {
        		pre.end = pre.end>intervals.get(i).end?pre.end:intervals.get(i).end;
        	}else {
        		pre = intervals.get(i);
        		res.add(pre);
        	}
        }
        return res;
    }
    
    public void sort(List<Interval> intervals, int low, int high) {
    	if(low < high) {
    		int part = partition(intervals, low, high);
    		sort(intervals, low, part-1);
    		sort(intervals, part+1, high);
    	}
    }
    
    public int partition(List<Interval> intervals, int low, int high) {
    	int index = low;
    	int p = intervals.get(low).start;
    	for(int i=low+1; i<=high; i++) {
    		if(intervals.get(i).start < p) {
    			swap(intervals, ++index, i);
    		}
    	}
    	swap(intervals, low, index);
    	return index;
    }
    
    public void swap(List<Interval> intervals, int index1, int index2) {
    	Interval temp = intervals.get(index1);
    	intervals.set(index1, intervals.get(index2));
    	intervals.set(index2, temp);
    }
    
    public List<Interval> generInput(int[][] input) {
    	List<Interval> res = new ArrayList<>();
    	for(int[] num : input) 
    		res.add(new Interval(num[0], num[1]));
    	return res;
    }
    
	public static void main(String[] args) {
		P056 test = new P056();
		List<Interval> input = test.generInput(new int[][]{{2,6},{8,10},{15,18},{1,3}});
		test.merge(input);
	}

}
