import java.util.ArrayList;
import java.util.List;

/*Triangle
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
public class P120 {
	
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] sums = new int[triangle.size()];
        sums[0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++) {
        	int[] old = new int[i+2];
        	old[0] = Integer.MAX_VALUE;
        	old[i+1] = Integer.MAX_VALUE;
        	System.arraycopy(sums, 0, old, 1, i);
        	for(int j=0; j<=i; j++) {
        		int num = triangle.get(i).get(j);
        		sums[j] = old[j]<old[j+1]?old[j]+num:old[j+1]+num;
        	}
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<sums.length; i++) {
        	if(min > sums[i]) min = sums[i];
        }
        return min;
    }
    
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(5);
		List<List<Integer>> input = new ArrayList<>();
		input.add(list1);
		input.add(list2);
		System.out.println(minimumTotal(input));
	}

}
