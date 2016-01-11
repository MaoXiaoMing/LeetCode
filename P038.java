/*
 * Count and Say
 * 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * 
 * */
public class P038 {

	public String next(String input) {
		String result = "";
		int count = 1;
		for(int i=1; i<input.length(); i++) {
			if(input.charAt(i)==input.charAt(i-1)) {
				count++;
			}else {
				result = (result+count+input.charAt(i-1));
				count = 1;
			}
		}
		return result+count+input.charAt(input.length()-1);
	}
	
    public String countAndSay(int n) {
        String result = "1";
        while(n > 1) {
        	result = next(result);
        	n--;
        }
        return result;
    }
	
	public static void main(String[] args) {

	}

}
