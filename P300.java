
public class P300 {
	
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
    	int[] status = new int[nums.length];
        status[0] = 1;
        for(int i=1; i<nums.length; i++) {
        	int max = 1;
        	for(int j=0; j<i; j++) {
        		if(nums[i] > nums[j]) max = max<=status[j]+1?status[j]+1:max;
        	}
        	status[i] = max;
        }
        int res = 0;
        for(int i=0; i<status.length; i++) {
        	res = res<status[i]?status[i]:res;
        }
        return res;
    }
    
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5}));
	}

}
