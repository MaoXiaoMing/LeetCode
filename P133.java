import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

public class P133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node.label, copy);
		Set<Integer> visit = new HashSet<>();
		visit.add(node.label);
		for(UndirectedGraphNode neighbor : node.neighbors) {
			if(!map.containsKey(neighbor.label)) {
				UndirectedGraphNode temp = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor.label, temp);
			}
			copy.neighbors.add(map.get(neighbor.label));
			if(!visit.contains(neighbor.label)) {
				visit.add(neighbor.label);
				dfs(neighbor, map, visit);
			}
		}
		return copy;
    }
	
	public void dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map,
			Set<Integer> visit) {
		UndirectedGraphNode copy = map.get(node.label);
		for(UndirectedGraphNode neighbor : node.neighbors) {
			if(!map.containsKey(neighbor.label)) {
				UndirectedGraphNode temp = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor.label, temp);
			}
			copy.neighbors.add(map.get(neighbor.label));
			if(!visit.contains(neighbor.label)) {
				visit.add(neighbor.label);
				dfs(neighbor, map, visit);
			}
		}
	}
}