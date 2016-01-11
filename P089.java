import java.util.ArrayList;
import java.util.List;

public class P089 {
	
    public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<>();
    	if(n<0) return res;
    	if(n==0) {
    		res.add(0);
    		return res;
    	}
    	List<Integer> temp = grayCode(n-1);
    	res.addAll(temp);
    	int add = 1<<(n-1);
    	for(int i=temp.size()-1; i>=0; i--) {
    		res.add(add+temp.get(i));
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		new P089().grayCode(5);
	}

}
