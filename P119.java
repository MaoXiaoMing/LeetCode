import java.util.ArrayList;
import java.util.List;


/*
 * Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].*/

public class P119 {
	
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex); 
        List<Integer> last = new ArrayList<Integer>(rowIndex);
        if(rowIndex == 0) {
        	res.add(1);
        	return res;
        }
        for(int i=1; i<=rowIndex; i++) {
        	last.add(1);
        	for(int j=1; j<i; j++) {
        		last.add(res.get(j-1)+res.get(j));
        	}
        	last.add(1);
        	List<Integer> temp = last;
        	last = res;
        	res = temp;
        	last.clear();
        }
        return res;
    }
	
	public static void main(String[] args) {
		List<Integer> res = getRow(3);
		for(int i=0; i<res.size(); i++) {
			System.out.print(res.get(i)+"\t");
		}
	}

}
