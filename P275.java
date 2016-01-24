
/*275. H-Index II
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Show Hint 
*/
public class P275 {
	
    public int hIndex(int[] citations) {
    	if(citations==null || citations.length==0) return 0;
    	int low = 0;
    	int high = citations.length-1;
    	int length = citations.length;
    	if(citations[high] == 0) return 0;
    	while(true) {
    		if(low>=high) {
    			return length-low;
    		}
    		int mid = (low+high)/2;
    		if(length-mid > citations[mid]) {
    			low =  mid+1;
    		}else if(length-mid < citations[mid]) {
    			high = mid;
    		}else return citations[mid];
    	}
//        int res = citations.length;
//        for(int i=0; i<citations.length; i++) {
//        	if(citations[i] < res) 
//        		res--;
//        	else return res;
//        }
//        return res;
    }
    
	public static void main(String[] args) {
		P275 test = new P275();
		
	}

}
