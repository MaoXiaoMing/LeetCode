import java.util.Arrays;

public class P060 {
	
    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=nums.length-1; i>=0; i--) nums[i] = i+1;
        while(k > 1) {
        	nextPermutation(nums);
        	k--;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<nums.length; i++) {
        	sb.append(nums[i]);
        }
        return sb.toString();
    }
    
    public static void nextPermutation(int[] nums) {
    	int index1 = nums.length-2;
    	int index2 = nums.length-1;
    	boolean flag = true;
    	for(int i=nums.length-2; flag&&i>=0; i--) {
    		for(int j=nums.length-1; flag&&j>i; j--) {
    			if(nums[i] < nums[j]) {
    				index1 = i;
    				index2 = j;
    				flag = false;
    			}
    		}
    	}
    	nums[index1] ^= nums[index2];
    	nums[index2] ^= nums[index1];
    	nums[index1] ^= nums[index2];
    	Arrays.sort(nums, index1+1, nums.length);
    }
    
	public static void main(String[] args) {
//		System.out.println(getPermutation(3, 2));
		int a = 1;
		int b = 2;
//		System.out.println((a^=b));
//		System.out.println(b ^= (a ^= b));
		a ^= (b ^= (a ^= b));
//		System.out.println(a = a^b);
//		System.out.println(b = b^a);
//		System.out.println(a = a^b);
//		System.out.println();
//		a ^= b;
//		b ^= a;
//		a ^= b;
		System.out.println(a+"\t"+b);
	}

}
