import java.util.ArrayList;
import java.util.List;

/*
 * 57. Insert Interval
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
public class P057 {
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int index = 0;
        for( ; index < intervals.size(); index++) {
        	Interval element = intervals.get(index);
        	if(element.start >= newInterval.start) break;
        	res.add(element);
        }
        if(res.size()!=0 && res.get(res.size()-1).end>=newInterval.start) 
        	res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, newInterval.end);
        else res.add(newInterval);
        for( ; index<intervals.size(); index++) {
        	Interval element = intervals.get(index);
        	if(element.start > res.get(res.size()-1).end) {
        		res.add(element);
        	}else {
        		res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, element.end);
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {
		
	}

}
