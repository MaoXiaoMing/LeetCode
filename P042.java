
/*
 * 42. Trapping Rain Water My Submissions Question
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class P042 {
	
    public int trap(int[] height) {
        int max = 0;
        for(int i=1; i<height.length; i++) {
        	if(height[max] < height[i])
        		max = i;
        }
        int res = 0;
        for(int i=0, peak=0; i<max; i++) {
        	if(height[peak] < height[i]) peak = i;
        	res += height[peak]-height[i];
        }
        for(int i=height.length-1, peak=height.length-1; i>max; i--) {
        	if(height[peak] < height[i]) peak = i;
        	res += height[peak]-height[i];
        }
        return res;
    }
    
	public static void main(String[] args) {

	}
}
