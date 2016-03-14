import java.util.Arrays;

public class P238 {
    public int[] productExceptSelf(int[] nums) {
		int zeroCount = 0;
		int mult = 1;
		int[] res = new int[nums.length];
		int index = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==0) {
				if(zeroCount==1) {
					Arrays.fill(res, 0);
					return res;
				}
				zeroCount++;
				index = i;
			}else {
				mult *= nums[i];
			}
		}
		if(zeroCount==1) {
			res[index] = mult;
			return res;
		}
		int flag = mult>0?1:-1;
		double all = Math.log(Math.abs(mult));
		for(int i=0; i<nums.length; i++) {
			res[i] = (int)Math.round(Math.pow(Math.E, all-Math.log(Math.abs(nums[i]))))*flag*(nums[i]>0?1:-1);
		}
		return res;
    }
}