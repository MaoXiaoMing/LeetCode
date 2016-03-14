import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
		for(int i=0; i<prerequisites.length; i++) {
			indegree[prerequisites[i][0]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> order = new ArrayList<Integer>();
		for(int i=0; i<indegree.length; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
				order.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int index = queue.poll();
			for(int i=0; i<prerequisites.length; i++) {
				if(prerequisites[i][1]==index) {
					if((--indegree[prerequisites[i][0]])==0) {
						queue.offer(prerequisites[i][0]);
						order.add(prerequisites[i][0]);
					}
				}
			}
		}
		if(order.size()!=numCourses) return new int[0];
		for(int i=0; i<order.size(); i++) 
			indegree[i] = order.get(i);
		return indegree;
    } 	
}