
/*
 * Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.*/

public class P088 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 && n>0) {
        	if(nums1[m-1] < nums2[n-1]) {
        		nums1[m+n-1] = nums2[n-1];
        		n--;
        	}else {
        		nums1[m+n-1] = nums1[m-1];
        		m--;
        	}
        }
        while(n>0) {
        	nums1[n-1] = nums2[n-1];
        	n--;
        }
    }
	
	public static void main(String[] args) {
		merge(new int[]{1,5,9}, 2, new int[]{7}, 1);
	}

}
