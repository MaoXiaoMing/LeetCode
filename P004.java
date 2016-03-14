
/*4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).*/

public class P004 {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if(((nums1.length+nums2.length)&1) != 0) return find(nums1, 0, nums2, 0, (nums1.length+nums2.length+1)/2);
    	else return (find(nums1, 0, nums2, 0, (nums1.length+nums2.length)/2)
    			+find(nums1, 0, nums2, 0, (nums1.length+nums2.length)/2+1))/2.;
    }
    
    public double find(int[] nums1, int start1, int[] nums2, int start2, int k) {
    	if(nums2.length-start2<nums1.length-start1) return find(nums2, start2, nums1, start1, k);
    	if(start1==nums1.length) return nums2[k-1];
    	if(k==1) return Math.min(nums1[start1], nums2[start2]);
    	int ia = Math.min(k/2, nums1.length-start1);
    	int ib = k-ia;
    	if(nums1[start1+ia-1]>nums2[start2+ib-1]) return find(nums1, start1, nums2, start2+ib, k-ib);
    	else if(nums1[start1+ia-1]<nums2[start2+ib-1]) return find(nums1, start1+ia, nums2, start2, k-ia);
    	return nums1[start1+ia-1];
//    	if(start1>=nums1.length) return nums2[k-1];
//    	else if(start2>=nums2.length) return nums1[k-1];
//    	else if(k==1) return Math.min(nums1[start1], nums2[start2]);
//    	int index = Math.max(0, Math.min(k, Math.min(nums1.length-start1, nums2.length-start2))/2-1);
//    	if(nums2[start2+index]==nums1[start1+index]) return nums2[index+start2];
//    	if(nums1[start1+index] < nums2[start2+index]) return find(nums1, start1+index+1, nums2, start2, k-index-1);
//    	return find(nums1, start1, nums2, start2+index+1, k-index-1);
    }
    
	public static void main(String[] args) {
		P004 test = new P004();
		System.out.println(test.findMedianSortedArrays(new int[]{1}, new int[]{1}));
//		System.out.println(test.findMedianSortedArrays(new int[]{1,4,5}, new int[]{2,3,5}));
	}

}
