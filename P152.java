public class P152 {
    public int maxProduct(int[] nums) {
        int[] minArray = new int[nums.length];
		int[] maxArray = new int[nums.length];
		minArray[0] = maxArray[0] = nums[0];
		int max = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==0) {
				minArray[i] = maxArray[i] = 0;
			}else if(nums[i] < 0) {
				if(minArray[i-1]>0) {
					maxArray[i] = nums[i];
					minArray[i] = nums[i]*maxArray[i-1];
				}else if(maxArray[i-1]<0) {
					maxArray[i] = nums[i]*minArray[i-1];
					minArray[i] = nums[i];
				}else {
					maxArray[i] = minArray[i-1]*nums[i];
					minArray[i] = maxArray[i-1]==0?nums[i]:maxArray[i-1]*nums[i];
				}
			}else {
				if(minArray[i-1]>0) {
					maxArray[i] = nums[i]*maxArray[i-1];
					minArray[i] = nums[i];
				}else if(maxArray[i-1]<0) {
					maxArray[i] = nums[i];
					minArray[i] = nums[i]*minArray[i-1];
				}else {
					maxArray[i] = maxArray[i-1]==0?nums[i]:nums[i]*maxArray[i-1];
					minArray[i] = nums[i]*minArray[i-1];
				}
			}
			max = Math.max(max, maxArray[i]);
		}
		return max;
    }
}