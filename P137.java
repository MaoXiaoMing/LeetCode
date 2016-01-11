
/*
 * 137. Single Number II
Given an array of integers, every element appears three times except for one. Find that single one.
*/
public class P137 {
	
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        int there = 0;
        for(int i=0; i<nums.length; i++) {
        	two |= (one&nums[i]);
        	one ^= nums[i];
        	there = ~(two&one);
        	one &= there;
        	two &= there;
        }
        return one;
    }
    
	public static void main(String[] args) {

	}

}
