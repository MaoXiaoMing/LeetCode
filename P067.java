/*
 * Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class P067 {
	
    public static String addBinary(String a, String b) {
    	if(a.length() > b.length()) {
    		String temp = a;
    		a = b;
    		b = temp;
    	}
    	StringBuilder sb = new StringBuilder(a);
    	sb = sb.reverse();
    	for(int i=a.length(); i<b.length(); i++) {
    		sb.append('0');
    	}
    	a = sb.reverse().toString();
    	sb.delete(0, sb.length());
    	int flag = 0;
    	for(int i=a.length()-1; i>=0; i--) {
    		int sum = a.charAt(i)+b.charAt(i)-'0'-'0'+flag;
    		if(sum >= 2) {
    			flag = 1;
    			sum %= 2;
    		}else {
    			flag = 0;
    		}
    		sb.append(sum);
    	}
    	if(flag == 1) {
    		sb.append(1);
    	}
    	return sb.reverse().toString();
    }
    
	public static void main(String[] args) {
		addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
	}

}
