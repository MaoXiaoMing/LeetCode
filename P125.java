/*
 * Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.*/
public class P125 {
	public static boolean isPalindrome(String s) {
        if(s == null) return true;
        int low = 0;
        int high = s.length()-1;
        while(low < high) {
        	while(low<high && !Character.isAlphabetic(s.charAt(low)) 
        			&& !Character.isDigit(s.charAt(low))) {
        		low++;
        	}
        	while(low<high && !Character.isAlphabetic(s.charAt(high))
        			&& !Character.isDigit(s.charAt(high))) {
        		high--;
        	}
        	int sub = Math.abs(s.charAt(low)-s.charAt(high));
        	if(sub!=0 && sub!=32) {
        		return false;
        	}
        	low++;
        	high--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("1a2"));
	}

}
