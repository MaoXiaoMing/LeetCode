
/*
 * Excel Sheet Column Number
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.*/

public class P171 {
	
	public static int titleToNumber(String s) {
		if(s == null) return 0;
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			count = (count*26)+(s.charAt(i)-64);
		}
		return count;
    }
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
	}
}
