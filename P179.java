public class P179 {
    public String largestNumber(int[] nums) {
		String[] aux = new String[nums.length];
		for(int i=0; i<nums.length; i++) aux[i] = nums[i]+"";
		quickSort(aux, 0, aux.length-1);
		StringBuilder sb = new StringBuilder();
		for(String str : aux) sb.append(str);
		String str = sb.toString();
		int index = 0;
		for( ; index<str.length(); index++) {
			if(str.charAt(index) != '0') break;
		}
		if(index==str.length()) return "0";
		return str.substring(index);
    }
	
	public void quickSort(String[] nums, int low, int high) {
		if(low < high) {
			int part = partition(nums, low, high);
			quickSort(nums, low, part-1);
			quickSort(nums, part+1, high);
		}
	}
	
	public int partition(String[] nums, int low, int high) {
		int index = low;
		for(int i=low+1; i<=high; i++) {
			if(compare(nums[i], nums[low])>0) {
				swap(nums, ++index, i);
			}
		}
		swap(nums, low, index);
		return index;
	}
	
	public void swap(String[] nums, int index1, int index2) {
		String temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
	
	public int compare(String num1, String num2) {
//		int i=0;
//		int length1 = num1.length();
//		int length2 = num2.length();
//		for( ; i<length1&&i<length2; i++) {
//			if(num1.charAt(i)<num2.charAt(i)) return -1;
//			else if(num1.charAt(i)>num2.charAt(i)) return 1;
//		}
		return (num1+num2).compareTo(num2+num1);
//		if(i<length1) {
//			for( ; i<length1&&i-length2<length2; i++) {
//				if(num1.charAt(i)<num2.charAt(i-length2)) return -1;
//				else if(num1.charAt(i)>num2.charAt(i-length2)) return 1;
//			}
//			return 0;
//		}else {
//			for( ; i<length2&&i-length1<length1; i++) {
//				if(num2.charAt(i)<num1.charAt(i-length1)) return 1;
//				else if(num2.charAt(i)>num1.charAt(i-length1)) return -1;
//			}
//			return 0;
//		}
	}
}