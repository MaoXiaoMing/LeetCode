public class P209 {
    public int minSubArrayLen(int s, int[] nums) {
		if(nums==null || nums.length==0 || (nums.length==1&&nums[0]!=s)) return 0;
        int index = 1;
		int min = Integer.MAX_VALUE;
		int length = nums.length;
		int count = nums[0];
		int start = 0;
		while(index<=length) {
			if(count<s) {
			    if(index<length) count += nums[index++];
			    else return min==Integer.MAX_VALUE?0:min;
			}else if(count > s) {
				count -= nums[start++];
			}else{
				min = Math.min(min, index-start);
				count -= nums[start++];
			}
		}
		return min==Integer.MAX_VALUE?0:min;
    }
}