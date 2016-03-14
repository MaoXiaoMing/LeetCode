import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*332. Reconstruct Itinerary
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.*/
public class P332 {
	
	private int edgeNum;
	
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        buildGraph(graph, tickets);
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs(res, graph, "JFK", 0);
        return res;
    }
    
    public void buildGraph(Map<String, List<String>> graph, String[][] tickets) {
    	edgeNum = tickets.length;
    	for(int i=0; i<tickets.length; i++) {
    		List<String> source = graph.get(tickets[i][0]);
    		if(source == null) {
    			source = new ArrayList<String>();
        		graph.put(tickets[i][0], source);
    		}
    		source.add(tickets[i][1]);
    	}
    	for(String source : graph.keySet()) {
    		graph.get(source).sort(null);
    	}
    }
    
    public int dfs(List<String> res , Map<String, List<String>> graph, String current, int count) {
    	if(count == edgeNum) return 1;
    	List<String> candidate = graph.get(current);
    	if(candidate == null) return -1;
    	for(int i=0; i<candidate.size(); i++) {
    		String dele = candidate.remove(i);
    		res.add(dele);
    		if(dfs(res, graph, dele, count+1) == 1) return 1;
    		res.remove(res.size()-1);
    		candidate.add(i, dele);
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
    	P332 test = new P332();
    	test.findItinerary(new String[][]{{"JFK","KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}});
    }
    
}
