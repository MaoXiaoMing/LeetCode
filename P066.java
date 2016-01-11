
/*
 * Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class P066 {

	public int[] plusOne(int[] digits) {
		for (int i=digits.length-1; i>=0; i--) {
			digits[i] += 1;
			if(digits[i]==10) {
				digits[i] = 0;
			}else{
				return digits;
			}
		}
		int[] result = new int[digits.length+1];
		result[0] = 1;
		for(int i=1; i<result.length; i++) {
			result[i] = 0;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
