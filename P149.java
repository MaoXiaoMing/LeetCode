import java.util.HashMap;
import java.util.Map;

/*149. Max Points on a Line
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.*/

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

public class P149 {
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int max = 0;
        for(int i=0; i<points.length; i++) {
        	Map<Double, Integer> count = new HashMap<>();
        	int samePoint = 0;
        	int sameX = 0;
        	for(int j=0; j<points.length; j++) {
        		if(i == j) continue;
        		else if(points[i].x==points[j].x) {
        			if(points[i].y == points[j].y) samePoint++;
        			sameX++;
        			continue;
        		}
        		double slope = ((double) points[i].y-points[j].y) / (points[i].x-points[j].x);
        		if(!count.containsKey(slope)) count.put(slope, 2);
        		else count.put(slope, count.get(slope)+1);
        	}
        	for(double slope : count.keySet()) {
        		max = Math.max(max, count.get(slope)+samePoint);
        	}
        	max = Math.max(max, sameX+1);
        }
        return max;
    }
}
