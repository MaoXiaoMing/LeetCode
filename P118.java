import java.util.ArrayList;
import java.util.List;


/*
 * Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class P118 {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) {
        	return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for(int i=1; i<numRows; i++) {
        	List<Integer> last = result.get(i-1);
        	list = new ArrayList<>();
        	list.add(1);
        	for(int j=1; j<last.size(); j++) {
        		list.add(last.get(j-1)+last.get(j));
        	}
        	list.add(1);
        	result.add(list);
        }
        return result;
    }
	
	public static void display(List<List<Integer>> list) {
		for(int i=0; i<list.size(); i++) {
			List<Integer> sub = list.get(i);
			for(int j=0; j<sub.size(); j++) {
				System.out.print(sub.get(j)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		display(generate(5));
	}

}
