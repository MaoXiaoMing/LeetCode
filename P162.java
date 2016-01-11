
public class P162 {
	
    public int findPeakElement(int[] nums) {
    	int low = 0;
    	int high = nums.length-1;
    	while(low < high) {
    		int mid = (low + high)/2;
    		if(nums[mid] < (mid>0?nums[mid-1]:Integer.MIN_VALUE)) high = mid;
    		else if(nums[mid] < (mid<nums.length-1?nums[mid+1]:Integer.MIN_VALUE)) low=mid+1;
    		else return mid;
    	}
    	return low;
/*      int low = 0;
        int high = nums.length-1;
    	while(true) {
        	if(low >= high) return high;
        	int mid = (low+high)/2;
        	if(nums[mid] < nums[low]) {
        		high = mid;
        		continue;
        	}else if(nums[mid] > nums[high]) {
        		low = mid;
        		continue;
        	}
        }*/
    }
    
	public static void main(String[] args) {
		P162 p = new P162();
		System.out.println(p.findPeakElement(new int[]{3,2,1}));
	}

}
