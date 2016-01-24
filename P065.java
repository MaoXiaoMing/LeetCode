
/*
 * 65. Valid Number
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous.
You should gather all requirements up front before implementing one.
*/
public class P065 {
	
    public boolean isNumber(String s) {
    	if(s==null) return false;
    	String input = s.trim();
    	if(input.trim().length() == 0) return false;
        int index = input.indexOf('e');
        if(index == -1) 
        	return part1(input, input.length()-1);
        else return part1(input, index-1)&&part2(input, index+1);
    }
    
    public boolean part1(String s, int end) {
    	if(end < 0) return false;
    	String test = s.substring(0, end+1);
    	if(test.equals(".") || test.equals("+") ||test.equals("-")) return false;
    	int start = s.charAt(0)=='-'||s.charAt(0)=='+'?1:0;
    	boolean dot = false;
    	boolean dig = false;
    	for(int i=start; i<=end; i++) {
    		char c = s.charAt(i);
    		if(!dot && c=='.') dot = true;
    		else if(c>='0'&&c<='9') dig = true;
    		else return false;
    	}
    	return dig;
    }
    
    public boolean part2(String s, int start) {
    	if(start == s.length()) return false;
    	String test = s.substring(start);
    	if(test.equals(".") || test.equals("+") ||test.equals("-")) return false;
    	int first = s.charAt(start)=='-'||s.charAt(start)=='+'?start+1:start;
    	for(int i=first; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if(c<'0'||c>'9') return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		P065 test = new P065();
		System.out.println(test.isNumber("."));
	}

}
