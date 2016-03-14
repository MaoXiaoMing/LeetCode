import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*335. Self Crossing
You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

Example 1:
Given x = [2, 1, 1, 2],
┌───┐
│   │
└───┼──>
    │

Return true (self crossing)
Example 2:
Given x = [1, 2, 3, 4],
┌──────┐
│      │
│
│
└────────────>

Return false (not self crossing)
Example 3:
Given x = [1, 1, 1, 1],
┌───┐
│   │
└───┼>

Return true (self crossing)*/

public class P335 {
	
    public boolean isSelfCrossing(int[] x) {
        if(x.length <= 3) return false;
        int i = 2;
        while(i<x.length && x[i]>x[i-2]) i++;
        if(i>=x.length) return false;
        if((i==3 && x[i]==x[i-3]) || (i>=4 && x[i]>=x[i-2]-x[i-4])) x[i-1] -= x[i-3];
        i++;
        while(i<x.length) {
        	if(x[i]>=x[i-2]) return true;
        	i++;
        }
        return false;
    }
	
//	public Point genNext(int direction, Point pre, int length) {
//		if(direction==0) return new Point(pre.x, pre.y+length);
//		else if(direction==1) return new Point(pre.x-length, pre.y);
//		else if(direction==2) return new Point(pre.x, pre.y-length);
//		else return new Point(pre.x+length, pre.y);
//	} 
//	
//	public boolean isIntersect(int direction, Segment seg, List<Segment>[] array) {
//		for(int i=0; i<array[(direction+1)%4].size(); i++) {
//			if(intersect(seg, array[(direction+1)%4].get(i), direction)) return true;
//		}
//		return false;
//	}
//	
//	public boolean intersect(Segment s1, Segment s2, int direction) {
//		if(direction == 0) {
//			if(s1.start.y<=s2.start.y && s1.end.y>=s2.start.y && s2.start.x>=s1.start.x && s2.end.x<=s1.start.x)
//				return true;
//			else return false;
//		}else if(direction == 1) {
//			if(s1.start.x>=s2.start.x && s1.end.x<=s2.start.x && s2.start.y>=s1.start.y && s2.end.y<=s1.start.y)
//				return true;
//			else return false;
//		}else if(direction == 2) {
//			if(s1.start.y>=s2.start.y && s1.end.y<=s2.start.y && s2.start.x<=s1.start.x && s2.end.x>=s1.start.x) 
//				return true;
//			else return false;
//		}else {
//			if(s1.start.x<=s2.start.x && s1.end.x>=s2.start.x && s2.start.y<=s1.start.y && s2.end.y>=s1.start.y) 
//				return true;
//			else return false;
//		}
//	}
//	
//	public boolean helper(int direction, Segment seg, List<Segment>[] array) {
//		List<Segment> list = array[direction]; 
//		for(int i=0; i<list.size(); i++) {
//			Segment other = list.get(i);
//			if(direction == 0) {
//				if(seg.start.x==other.start.x && seg.end.y>=other.start.y) return true;
//			}else if(direction == 1) {
//				if(seg.start.y==other.start.y && seg.end.x<=other.start.x) return true;
//			}else if(direction == 2) {
//				if(seg.start.x==other.start.x && seg.end.y<=other.start.y) return true;
//			}else {
//				if(seg.start.y==other.start.y && seg.end.x>=other.start.x) return true;
//			}
//		}
//		return false;
//	}
//	
//    public boolean isSelfCrossing(int[] x) {
//        List<Segment>[] array = new ArrayList[4];
//        for(int i=0; i<array.length; i++) array[i] = new ArrayList<>();
//        Point pre = new Point(0, 0), next;
//        for(int i=0; i<x.length; i++) {
//        	next = genNext(i%4, pre, x[i]); 
//        	Segment seg = new Segment(pre, next);
//        	if(isIntersect(i%4, seg, array) || helper(i%4, seg, array)) return true;
//        	array[i%4].add(seg);
//        	pre = next;
//        }
//        return false;
//    }
    
}
