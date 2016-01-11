
/*
 * 43. Multiply Strings
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
public class P043 {
	
    public String multiply(String num1, String num2) {
    	if(num1.equals("0")||num2.equals("0")) return "0";
        String res = "";
        for(int i=0; i<num2.length(); i++) {
        	res = add(res+"0", mul(num1, num2.charAt(i)));
        }
        return res;
    }
    
    public String add(String num1, String num2) {
    	int index1 = num1.length()-1;
    	int index2 = num2.length()-1;
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	for( ; index1>=0&&index2>=0; index1--,index2--) {
    		int sum = num1.charAt(index1)+num2.charAt(index2)-'0'-'0'+carry;
    		sb.append(sum%10);
    		carry = sum/10;
    	}
    	while(index1>=0) {
    		int sum = num1.charAt(index1)-'0'+carry;
    		sb.append(sum%10);
    		carry = sum/10;
    		index1--;
    	}
    	while(index2>=0) {
    		int sum = num2.charAt(index2)-'0'+carry;
    		sb.append(sum%10);
    		carry = sum/10;
    		index2--;
    	}
    	if(carry == 1) sb.append(1);
    	return sb.reverse().toString();
    }
    
    public String mul(String num1, char num2) {
    	if(num2 == '0') return "0";
    	int fac = num2-'0';
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i=num1.length()-1; i>=0; i--) {
    		int mu = fac*(num1.charAt(i)-'0')+carry;
    		sb.append(mu%10);
    		carry = mu/10;
    	}
    	if(carry != 0) sb.append(carry);
    	return sb.reverse().toString();
    }
    
	public static void main(String[] args) {
		P043 p = new P043();
		System.out.println(p.mul("348274", '5'));
		System.out.println(p.add("123", "12465"));
		System.out.println(p.multiply("0", "727472882952"));
	}

}
