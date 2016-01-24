import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 207. Course Schedule
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/
public class P207 {
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> graph = new ArrayList<>();
    	for(int i=0; i<numCourses; i++) {
    		graph.add(new ArrayList<Integer>());
    	}
    	for(int i=0; i<prerequisites.length; i++) 
    		graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    	boolean[] visit = new boolean[numCourses];
    	for(int i=0; i<numCourses; i++) {
    		if(!visit[i]) {
    			Set<Integer> pre = new HashSet<>();
    			if(hasCircle(i, visit, graph, pre)) return false;
    		}
    	}
    	return true;
    }
    
    public boolean hasCircle(int index, boolean[] visit, 
    		List<List<Integer>> graph, Set<Integer> pre) {
    	visit[index] = true;
    	for(int i : graph.get(index)) {
    		if(pre.contains(i)) return true;
    		if(!visit[i]) {
    			pre.add(index);
    			if(hasCircle(i, visit, graph, pre)) return true;
    		}
    	}
    	return false;
//    	for(int i=0; i<graph[index].length; i++) {
//    		if(graph[index][i]==true) {
//    			if(pre.contains(i)) return true;
//    			else {
//    				pre.add(index);
//    				if(hasCircle(i, visit, graph, pre)) return true;
//    			}
//    		}
//    	}
//    	return false;
    }
    
	public static void main(String[] args) {
		P207 p = new P207();
		p.canFinish(3, new int[][]{{0,1}, {0, 2}, {1,2}});
	}

}
