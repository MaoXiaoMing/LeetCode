/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */
public class P168 {
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
        	sb.append((char)(n%26+'A'));
        	n /= 26;
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
	}
}
