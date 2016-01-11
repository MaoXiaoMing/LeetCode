
/*
 * String to Integer (atoi)
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.*/
public class P008 {
	
	public static int myAtoi(String str) {
		str = str.trim();
		if(str.equals("")) return 0;
		int i = 0;
		if(str.charAt(0)=='-' || str.charAt(0)=='+') i++;
		int result = 0;
		for( ; i<str.length(); i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				int pre = result;
				result = result*10+(str.charAt(i)-'0');
				if(result/10 != pre) {
					return str.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
				}
			}else {
				return str.charAt(0)=='-'?-result:result;
			}
		}
		return str.charAt(0)=='-'?-result:result;
    }
	
	public static void main(String[] args) {
		myAtoi("    10522545459");
	}

}
