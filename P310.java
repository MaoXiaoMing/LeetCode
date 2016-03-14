import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*310. Minimum Height Trees
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]*/
public class P310 {
	
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	if(n<=1) {
    		List<Integer> res = new ArrayList<>();
    		if(n==1) res.add(0);
    		return res;
    	}
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	for(int i=0; i<edges.length; i++) {
    		List<Integer> list = map.get(edges[i][0]);
    		if(list == null) {
    			list = new ArrayList<>();
    			map.put(edges[i][0], list);
    		}
    		list.add(edges[i][1]);
    		list = map.get(edges[i][1]);
    		if(list == null) {
    			list = new ArrayList<>();
    			map.put(edges[i][1], list);
    		}
    		list.add(edges[i][0]);
    	}
    	Queue<Integer> queue = new LinkedList<>();
    	for(int index : map.keySet()) {
    		if(map.get(index).size() == 1) queue.offer(index);
    	}
    	int count = 0;
    	while(count < edges.length-1) {
    		int size = queue.size();
    		count += size;
    		for(int i=0; i<size; i++) {
    			int index = queue.poll();
    			List<Integer> nodes = map.get(index);
    			for(int next : nodes) {
    				List<Integer> neighbour = map.get(next);
    				neighbour.remove(new Integer(index));
    				if(neighbour.size() == 1) queue.offer(next);
    			}
    		}
    	}
    	return new ArrayList<>(queue);
    }
    
	public static void main(String[] args) {
		P310 test = new P310();
		test.findMinHeightTrees(4, new int[][]{{1,0}, {1,2}, {1,3}});
	}

}
