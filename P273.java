
/*273. Integer to English Words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"*/
public class P273 {

	private String[] aux = new String[]{"", "Thousand", "Million", "Billion"};
	private String[] sw = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "SixTeen",
			"Seventeen", "Eighteen", "Nineteen"};
	private String[] sww = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private String[] gw = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
  
	public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return recursion(num, 0, "");
    }
	
	public String recursion(int num, int ws, String path) {
		if(num == 0) return path;
		int current = num%1000;
		return recursion(num/1000, ws+1, helper(current, ws)+path).trim();
	}
	
	public String helper(int num, int ws) {
		String result = "";
		if(num==0) return result;
		int bw = num/100;
		int s = num%100/10;
		if(bw > 0) result += gw[bw-1]+" "+"Hundred ";
		if(s==1) {
			result += sw[num%10]+" ";
		}else {
			if(s>1) {
				result += sww[s-2]+" ";
			}
			if(num%10!=0) result+=gw[num%10-1]+" "; 
		} 
		return result+aux[ws]+" ";
	}
	
	public static void main(String[] args) {
		P273 test = new P273();
		for(int i=190101; i<=242532; i++) 
			System.out.println(test.numberToWords(i));
	}

}
